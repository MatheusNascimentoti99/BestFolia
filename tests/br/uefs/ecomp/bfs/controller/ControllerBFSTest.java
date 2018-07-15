package br.uefs.ecomp.bfs.controller;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.bfs.model.*;

import br.uefs.ecomp.bfs.util.Iterador;

public class ControllerBFSTest {

	private Bloco b1, b2, b3;	
	private Foliao f1, f2, f3;
	private Transporte t1, t2, t3;
	
	ControllerBFS controller = new ControllerBFS();

	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void testCadastrarBloco() {
		assertEquals(0, controller.blocos.tamanho());
		b1 = controller.cadastrarBloco("Dormir � o Melhor Rem�dio", "Feira de Santana", 01);
		assertEquals(1, controller.blocos.tamanho());
		b2 = controller.cadastrarBloco("A Velha Debaixo da Cama", "Olinda", 02);
		b3 = controller.cadastrarBloco("Os Mascarados", "Aracaju", 03);
		assertEquals(3, controller.blocos.tamanho());
	}
	
	@Test
	public void testCadastrarFoliao() {
		assertEquals(0, controller.folioes.tamanho());
		f1 = controller.cadastrarFoliao("012345678-90", "666666 SSP/BA", "Jos� Roela", 30);  
		assertEquals(1, controller.folioes.tamanho());
		f2 = controller.cadastrarFoliao("000000000-00", "666666 SSP/AC", "Ant�nio Liso", 20);  
		f3 = controller.cadastrarFoliao("111111111-11", "666666 SSP/PE", "Maria Desespero", 40);  
		assertEquals(3, controller.folioes.tamanho());
	}
		
	@Test
	public void testCadastrarTransporte() {
		b1 = controller.cadastrarBloco("Dormir � o Melhor Rem�dio", "Feira de Santana", 01);
		b2 = controller.cadastrarBloco("A Velha Debaixo da Cama", "Olinda", 02);
		b3 = controller.cadastrarBloco("Os Mascarados", "Aracaju", 03);
				
		t1 = controller.cadastrarTransporte("Viagens Bahia", "Van", 34.8, 10, 01, "Feira - UEFS", 
									01, "Salvador", 02, "Feira - Rodovi�ria", b1);
		
		t2 = controller.cadastrarTransporte("Feira Viagens", "�nibus", 21.5, 40, 02, "Matinha", 
									02, "Salvador", 02, "Bara�nas", b2);
		
		t3 = controller.cadastrarTransporte("Teste", "Carro", 21.5, 40, 01, "XXX", 
									01, "YYY", 01, "ZZZ", b1);
		
		Iterador iterador = controller.listarTransportes(b1);
		assertTrue(iterador.temProximo());
		Transporte proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t1, proximoTransporte);	
		assertTrue(iterador.temProximo());
		proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t3, proximoTransporte);	
		assertFalse(iterador.temProximo());
		
		iterador = controller.listarTransportes(b2);
		assertTrue(iterador.temProximo());
		proximoTransporte = (Transporte) iterador.proximo();
		assertSame(t2, proximoTransporte);		
		assertFalse(iterador.temProximo());
		
		
		f1 = controller.cadastrarFoliao("012345678-90", "666666 SSP/BA", "Jos� Roela", 30);
		f2 = controller.cadastrarFoliao("000000000-00", "666666 SSP/AC", "Ant�nio Liso", 20);
		f3 = controller.cadastrarFoliao("111111111-11", "666666 SSP/PE", "Maria Desespero", 40);
		
		
		assertTrue(controller.registrarFoliaoEmTransporte(f1, t1));
		assertTrue(controller.registrarFoliaoEmTransporte(f2, t2));		
		assertTrue(controller.registrarFoliaoEmTransporte(f3, t2));
		assertFalse(controller.registrarFoliaoEmTransporte(f3, t2));		
		
		
		iterador = controller.listarFolioes(t2);
		assertTrue(iterador.temProximo());
		Foliao proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f2, proximoFoliao);		
		assertTrue(iterador.temProximo());
		proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f3, proximoFoliao);
		assertFalse(iterador.temProximo());
		
		
		iterador = controller.listarFolioes(t1);
		assertTrue(iterador.temProximo());
		proximoFoliao = (Foliao) iterador.proximo();
		assertSame(f1, proximoFoliao);		
		assertFalse(iterador.temProximo());
				
	}

}
