package br.uefs.ecomp.bfs.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes de unidade para a classe {@link Foliao}
 */
public class FoliaoTest {

	private Foliao f;
	
	
	/**
     * Este m�todo � executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que s�o utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        f = new Foliao("012345678-90", "666666 SSP/BA", "Jos� Roela", 30);        
    }

    /**
     * Teste de unidade que verifica se os atributos de um foli�o s�o atribuidos e 
     * modificados corretamente. Al�m disso, ele checa se o m�todo equals que 
     * compara dois foli�es foi implementado corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("012345678-90", f.getCpf());
        assertEquals("666666 SSP/BA", f.getRg());
        assertEquals("Jos� Roela", f.getNome());
        assertEquals(30, f.getIdade());
        
        f.setCpf("000000000-00");
        f.setRg("000000 SSP/AC");
        f.setNome("Ana Cecilia da Cruz");
        f.setIdade(20);
        assertEquals("000000000-00", f.getCpf());
        assertEquals("000000 SSP/AC", f.getRg());  
        assertEquals("Ana Cecilia da Cruz", f.getNome());
        assertEquals(20, f.getIdade());
        
        Foliao temp = new Foliao("000000000-00", "000000 SSP/AC", "Ana Cecilia da Cruz", 20);
        assertTrue(temp.equals(f));
        
        f.setCpf("000000000-01");        
        assertFalse(temp.equals(f));
        
        f.setRg("000001 SSP/PB");         
        f.setCpf("000000000-00");
        assertFalse(temp.equals(f));
        
        f.setNome("Carlos Correia");         
        f.setRg("000000 SSP/AC"); 
        assertFalse(temp.equals(f));
        
        f.setIdade(40);
        f.setNome("Ana Cecilia da Cruz");
        assertFalse(temp.equals(f));
    }
}
