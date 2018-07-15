/*******************************************************************************
Autor: Matheus Nascimento Pereira de Lima
Componente Curricular: MI Programação 
Concluido em: 15/04/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.bfs.facade;

import br.uefs.ecomp.bfs.controller.ControllerBFS;
import br.uefs.ecomp.bfs.model.*;
import br.uefs.ecomp.bfs.util.*;

public class BFSFacade {

    ControllerBFS controller;

    public BFSFacade() {
        this.controller = new ControllerBFS();
    }

    //chamadas do controller
    public Bloco cadastrarBloco(String nome, String local, int saida) {
        return controller.cadastrarBloco(nome, local, saida);
    }

    public Bloco obterBloco(int id) {
        return controller.obterBloco(id);
    }

    public Iterador listarBlocos(String local, int dataInicio, int dataFim) {
        return this.controller.listarBlocos(local, dataInicio, dataFim);
    }

    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade,
            int saida, String localSaida, int retorno, String localRetorno,
            int chegada, String localChegada, Bloco bloco) {
        return controller.cadastrarTransporte(nome, tipo, valor, capacidade, saida, localSaida,
                retorno, localRetorno, chegada, localChegada, bloco);
    }

    public Transporte obterTransporte(int id) {
        return controller.obterTransporte(id);
    }

    public Iterador listarTransportes(Bloco bloco) {
        return this.controller.listarTransportes(bloco);
    }

    public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade) {
        return controller.cadastrarFoliao(cpf, rg, nome, idade);
    }

    public Foliao obterFoliao(String cpf) {
        return controller.obterFoliao(cpf);
    }

    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte) {
        return this.controller.registrarFoliaoEmTransporte(foliao, transporte);
    }

    public Iterador listarFolioes(Transporte transporte) {
        return this.controller.listarFolioes(transporte);
    }

}
