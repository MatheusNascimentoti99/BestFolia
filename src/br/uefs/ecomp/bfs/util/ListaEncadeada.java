package br.uefs.ecomp.bfs.util;

import java.util.Objects;

public class ListaEncadeada implements ILista {

    
    private Celula primeira;
    private Celula ultima;
    private int quantidadeDeNo;

    //Contrutor da ListaEncadeada
    public ListaEncadeada() {
        primeira = null;
        ultima = null;
        quantidadeDeNo = 0;

    }

    //Getteres e Setteres da ListaEncadeada


    //-----------------------------------------------------------------------------------------------------
    @Override
    public boolean estaVazia() {
        return (this.primeira == null);
    }

    @Override
    public int tamanho() {
        return quantidadeDeNo;
    }

    @Override
    public void insereInicio(Object objeto) {
        if (objeto != null) {                //Verifica se o Objeto existe.
            Celula novo = new Celula(objeto);    //Cria um objeto do tipo Célula/No com o objeto/dado dentro dessa célula
            if (this.estaVazia()) {                //Se estiver vazia, então a primeira celula também será a ultima
                novo.setProxima(null);
                this.ultima = novo;

            }
            novo.setProxima(this.primeira);         //Para os outro casos, onde já há celulas na lista.
            this.primeira = novo;
            this.quantidadeDeNo++;                  //Adiciona "+1" a quantidadeDeNo toda vez que um objeto é adicionado no início
        }
    }

    @Override
    public void insereFinal(Object objeto) {
        if (objeto != null) {               //Verifica se o Objeto existe.
            if (this.quantidadeDeNo == 0) {     //Se estiver vazia, então a primeira celula também será a ultima
                insereInicio(objeto);
            } else {                                //Para os outro casos, onde já há celulas na lista.
                Celula nova = new Celula(objeto);
                nova.setProxima(null);
                this.ultima.setProxima(nova);
                this.ultima = nova;
                this.quantidadeDeNo++;
            }
        }
    }

    @Override
    public Object removeInicio() {
        Object removido;
        if (0 == tamanho()) {       //Se a lista estiver vázia, então retorna null.
            return null;
        }
        //A célula passa para a próxima, assim deixando de existir na lista a celula anterior.
        removido = primeira.getObjeto();
        primeira = primeira.getProxima();
        this.quantidadeDeNo--;
        return removido;        //retorna o objeto/dado removido.

    }

    @Override
    public Object removeUltimo() {
        int contador = 0;
        final int penultimo = 2;        //Valor para a lista ir até o penultimo
        Celula auxiliar = primeira;
        Celula objetoRemovido;
        if (estaVazia()) {
            return null;
        }
        //Se existir apenas um Nó na lista
        if (quantidadeDeNo == 1) {
            objetoRemovido = auxiliar;
            ultima = null;
            primeira = null;
            quantidadeDeNo--;
            return objetoRemovido.getObjeto();
        }

        while (contador + penultimo < quantidadeDeNo) {     //Percorre a lista até o penultimo
            contador++;
            auxiliar = auxiliar.getProxima();
        }
        objetoRemovido = auxiliar.getProxima();             //Recebe o ultimo objeto que será removido
        auxiliar.setProxima(null);
        this.ultima = auxiliar;                             //A celula auxiliar que era a penultima, vira a ultima
        this.quantidadeDeNo--;                              //Decrementa a quantidade de celulas

        return objetoRemovido.getObjeto();                  //Retorna o objeto/dado removido.
    }

    @Override
    public Object recupera(int index) {
        int contador = 0;
        Celula auxiliar = this.primeira;
        if (index > quantidadeDeNo || index < 0) {              //Verifica se o valor do ID é válido
            return null;
        }

        while (index != contador) {                 //Percorre a lista até o final ou até encontra o Index
            contador++;
            auxiliar = auxiliar.getProxima();
        }
        return auxiliar.getObjeto();                //Retorna o objeto/dado procurado.
    }

    @Override
    public IteradorImplementacao iterador() {
        return new IteradorImplementacao();         //Cria o iterador da lista.
    }

    //Usa todo o objeto para comparação
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaEncadeada other = (ListaEncadeada) obj;
        if (this.quantidadeDeNo != other.quantidadeDeNo) {
            return false;
        }
        if (!Objects.equals(this.primeira, other.primeira)) {
            return false;
        }
        return Objects.equals(this.ultima, other.ultima);
    }

//----------------------------------------------------Subclasses-----------------------------------------------------
    public class IteradorImplementacao implements Iterador {

        private Celula atual;

        @Override
        public boolean temProximo() {   //verifica se o ponto onde o iterador está apontando existe.        
            return (atual != null);
        }

        @Override
        public Object proximo() {       //Passa para a proxima célula da lista
            if (temProximo()) {
                Celula conteudo = atual;
                atual = atual.getProxima();
                return conteudo.getObjeto(); //retorna o objeto dentro da celula que o iterador estava apontando anteriormente
            }
            return null;                //Nulo se não tiver próximo
        }
        //Contrutor do iterador, pegando a primeira célula da lista.

        public IteradorImplementacao() {
            this.atual = primeira;
        }

    }
    private class Celula {

        private Celula proxima;
        private Object objeto;

        public Celula(Object objeto) {  //Cria a celula adicionando um novo objeto dentro dela
            this.objeto = objeto;
        }

        //Getteres e Setteres da Celula
        public Object getObjeto() {
            return objeto;
        }

        public void setObjeto(Object objeto) {
            this.objeto = objeto;
        }

        public void setProxima(Celula proxima) {
            this.proxima = proxima;
        }

        public Celula getProxima() {
            return proxima;
        }

    }

}
