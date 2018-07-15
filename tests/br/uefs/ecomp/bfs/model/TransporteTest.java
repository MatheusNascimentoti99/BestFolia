package br.uefs.ecomp.bfs.model;


import java.util.Date;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.bfs.model.Bloco;

/**
 * Testes de unidade para a classe {@link Transporte}
 */
public class TransporteTest {
    private Transporte t;
    private Bloco b1, b2;
    
    /**
     * Este m�todo � executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que s�o utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
    	b1 = new Bloco("Spanta Beb�", "Salvador - Farol da Barra", 22);
        b2 = new Bloco("Massacration", "Salvador - Farol da Barra", 22);
        
    	t = new Transporte("Viagens Bahia", "Van", 34.8, 10, 23, "Feira - UEFS", 
    						24, "Salvador", 25, "Feira - Rodovi�ria", b1);
    }
   
    /**
     * Teste de unidade que verifica se os atributos de um transporte s�o 
     * atribuidos e modificados corretamente. Al�m disso, ele checa se o m�todo 
     * que compara dois transportes foi implementado corretamente.
     */
    @Test
    public void testBasic() {
    	assertEquals("Viagens Bahia", t.getNome());
    	assertEquals("Van", t.getTipo());
        assertEquals(34.8, t.getValor(), 0);        
        assertEquals(10, t.getCapacidade());
        assertEquals(23, t.getSaida());
        assertEquals("Feira - UEFS", t.getLocalSaida());
        assertEquals(24, t.getRetorno());
        assertEquals("Salvador", t.getLocalRetorno());
        assertEquals(25, t.getChegada());
        assertEquals("Feira - Rodovi�ria", t.getLocalChegada());
        assertTrue(b1.equals(t.getBloco()));
        
        t.setNome("Feira Viagens");
        t.setTipo("�nibus");
        t.setValor(21.5);
        t.setCapacidade(40);        
        t.setSaida(03);
        t.setLocalSaida("Matinha");
    	t.setRetorno(04);
    	t.setLocalRetorno("Farol da Barra");
    	t.setChegada(05);
    	t.setLocalChegada("Bara�nas");    
    	t.setBloco(b2);

        assertEquals("Feira Viagens", t.getNome());
        assertEquals("�nibus", t.getTipo());
        assertEquals(21.5, t.getValor(), 0);  
        assertEquals(40, t.getCapacidade());
        assertEquals(03, t.getSaida());
        assertEquals("Matinha", t.getLocalSaida());
        assertEquals(04, t.getRetorno());
        assertEquals("Farol da Barra", t.getLocalRetorno());
        assertEquals(05, t.getChegada());
        assertEquals("Bara�nas", t.getLocalChegada());
        assertTrue(b2.equals(t.getBloco()));
        
        Transporte temp = new Transporte("Feira Viagens", "�nibus", 21.5, 40, 03, "Matinha", 
        								04, "Farol da Barra", 05, "Bara�nas", b2);
        assertTrue(temp.equals(t));
        
        t.setNome("vvv");        
        assertFalse(temp.equals(t));
        
        t.setTipo("ttt");         
        t.setNome("Feira Viagens");
        assertFalse(temp.equals(t));
        
        t.setValor(0.1);         
        t.setTipo("�nibus"); 
        assertFalse(temp.equals(t));
        
        t.setCapacidade(10);  
        t.setValor(21.5);
        assertFalse(temp.equals(t)); 
                
        t.setSaida(07);
    	t.setCapacidade(40);     
        assertFalse(temp.equals(t));        
        
        t.setRetorno(8);
    	t.setSaida(03);
        assertFalse(temp.equals(t));        

        t.setChegada(9);
    	t.setRetorno(04);
        assertFalse(temp.equals(t));
        
        t.setLocalSaida("ssss");         
        t.setChegada(05);
        assertFalse(temp.equals(t));
        
        t.setLocalRetorno("rrrr");         
        t.setLocalSaida("Matinha");
        assertFalse(temp.equals(t));
        
        t.setLocalChegada("cccc");
        t.setLocalRetorno("Farol da Barra");         
        assertFalse(temp.equals(t));
        
        t.setBloco(b1);
        t.setLocalChegada("Bara�nas");
        assertFalse(temp.getBloco().equals(t.getBloco()));
    }
    
 }
