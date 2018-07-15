package br.uefs.ecomp.bfs.controller;

import br.uefs.ecomp.bfs.model.*;

import br.uefs.ecomp.bfs.util.*;

public class ControllerBFS {
    
    public ILista blocos = new ListaEncadeada();       //Todos os blocos cadastrados
    public ILista folioes = new ListaEncadeada();      //Todos os folioes cadastrados
    private ILista transportes = new ListaEncadeada();  //Todos os transportes cadastrados
    private int idBloco;
    private int idTransporte;
    
    public Bloco cadastrarBloco(String nome, String local, int saida) {
        
        Iterador it = blocos.iterador();
        Bloco novo = new Bloco(nome, local, saida);
        while (it.temProximo()) {
            Bloco blocoCadastrado = (Bloco) it.proximo();
            if (novo.equals(blocoCadastrado)) {                 //Se o bloco já tiver cadastrado, então é retornado um valor nulo.
                return null;
                
            }
        }
        
        novo.setId(idBloco);                                //O novo bloco recebe um ID.
        idBloco++;
        blocos.insereInicio(novo);
        return novo;
    }
    
    public Bloco obterBloco(int id) {
        if (id >= 0 && id < blocos.tamanho()) {
            return (Bloco) blocos.recupera(id);
        }
        return null;
    }
    
    public Iterador listarBlocos(String local, int dataInicio, int dataFim) {
        ILista listarBlocos = new ListaEncadeada();
        Iterador itTransporte = transportes.iterador();
        while (itTransporte.temProximo()) {                 //Percorre a lista de transportes
            Transporte transporte = (Transporte) itTransporte.proximo();     //recebe um dos blocos cadastrados
            /* Verifica o local, saida e retorno de um determinado transporte, se  */
            if (local.equals(transporte.getLocalChegada()) && (transporte.getSaida() >= dataInicio && transporte.getRetorno() <= dataFim)) {
                Iterador itBloco = listarBlocos.iterador();
                if (listarBlocos.estaVazia()) {
                    listarBlocos.insereInicio(transporte.getBloco());
                } else {
                    while (itBloco.temProximo()) {              //Para não ter repetições de blocos na lista
                        if (!((Bloco) itBloco.proximo()).equals(transporte.getBloco())) {
                            listarBlocos.insereInicio(transporte.getBloco());
                        }
                    }
                }
            }
        }
        
        return listarBlocos.iterador();
    }
    
    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, int saida,
            String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco bloco) {
        Iterador it = bloco.getTransportes().iterador();
        Transporte novo = new Transporte(nome, tipo, valor, capacidade, saida, localSaida,
                retorno, localRetorno, chegada, localChegada, bloco);
        while (it.temProximo()) {
            Transporte transporteCadastrado = (Transporte) it.proximo();
            if (novo.equals(transporteCadastrado)) {                //Verifica se o transporte já existe
                return null;
            }
        }
        novo.setId(idTransporte);
        idTransporte++;
        transportes.insereFinal(novo);
        bloco.getTransportes().insereFinal(novo);
        return novo;
    }
    
    public Transporte obterTransporte(int id) {
        if (id >= 0 && id < transportes.tamanho()) {
            return (Transporte) transportes.recupera(id);
        }
        return null;
    }
    
    public Iterador listarTransportes(Bloco bloco) {
        if (bloco != null) {
            return bloco.getTransportes().iterador();
        }
        return null;
    }
    
    public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade) {
        
        Iterador it = folioes.iterador();
        Foliao novo = new Foliao(cpf, rg, nome, idade);
        Foliao cadastrado;
        while (it.temProximo()) {
            cadastrado = (Foliao) it.proximo();
            if (novo.getCpf().equals(cadastrado.getCpf())) {        //Verifica se o transporte já existe
                return null;
            }
        }
        
        folioes.insereInicio(novo);
        return novo;
    }
    
    public Foliao obterFoliao(String cpf) {
        Foliao foliao;
        Iterador it = folioes.iterador();
        while (it.temProximo()) {
            foliao = (Foliao) it.proximo();
            if (foliao.getCpf().equals(cpf)) {              //Verifica se o transporte já existe
                return foliao;
            }
        }
        return null;
    }
    
    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte) {
        if (foliao == null || transporte == null) {     // Verifica se o foliao e o transporte existe.
            return false;
        }
        
        if (transporte.getFolioes().tamanho() < transporte.getCapacidade()) {       //Verifica se ainda há vaga para incluir foliao no transporte
            Iterador it = (Iterador) transporte.getFolioes().iterador();
            if (transporte.getFolioes().estaVazia()) {                              //Se a lista de folioes no transporte estiver vazia                         
                foliao.setTransporte(transporte);
                transporte.getFolioes().insereFinal(foliao);
                return true;
            }
            while (it.temProximo()) {
                Foliao foliaoCadastrado = (Foliao) it.proximo();
                if (foliao.getCpf().equals(foliaoCadastrado.getCpf())) {
                    return false;
                }
            }
            
            foliao.setTransporte(transporte);
            transporte.getFolioes().insereFinal(foliao);
            return true;
        }
        return false;
    }
    
    public Iterador listarFolioes(Transporte transporte) {
        if (transporte != null) {                         //Se o transporte existir, então retorna o iterador da lista de folioes em um transporte
            return transporte.getFolioes().iterador();
        }
        return null;
    }
    
    public ControllerBFS() {    //Para iniciar os id's.
        idBloco = 0;
        idTransporte = 0;
    }
    
}
