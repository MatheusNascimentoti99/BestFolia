package br.uefs.ecomp.bfs.util;

import br.uefs.ecomp.bfs.util.ListaEncadeada.*;

public interface ILista {

    public boolean estaVazia();

    public int tamanho();

    public void insereInicio(Object o);

    public void insereFinal(Object o);

    public Object removeInicio();

    public Object removeUltimo();

    public Object recupera(int index);

    public IteradorImplementacao iterador();

}
