package br.uefs.ecomp.bfs.model;

import br.uefs.ecomp.bfs.util.*;

public class Bloco {

    private int id;
    private String nome;
    private String local;
    private int saida;
    private ILista Transportes;

    //Construtor
    public Bloco(String nome, String local, int saida) {
        this.nome = nome;
        this.local = local;
        this.saida = saida;
        this.Transportes = new ListaEncadeada();
    }

    /*Getteres e Setteres do Bloco */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaida() {
        return this.saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ILista getTransportes() {
        return Transportes;
    }

    public void setTransportes(ILista listaTransportes) {
        this.Transportes = listaTransportes;
    }

    
    
    /* Verifica se o objeto é igual utilizando a saida, nome e o local do bloco*/
    @Override
    public boolean equals(Object obj) {
        Bloco bloco = (Bloco) obj;
        return ((this.saida == bloco.getSaida()) && (this.nome == null ? nome == null : this.nome.equals(bloco.getNome())) && (this.local == null ? local == null : this.local.equals(bloco.getLocal())));
    }

}
