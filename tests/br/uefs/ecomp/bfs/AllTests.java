package br.uefs.ecomp.bfs;

import br.uefs.ecomp.bfs.controller.ControllerBFSTest;
import br.uefs.ecomp.bfs.model.*;
import br.uefs.ecomp.bfs.util.ListaEncadeadaTest;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListaEncadeadaTest.class,
	BlocoTest.class,
	FoliaoTest.class,
	TransporteTest.class,
	ControllerBFSTest.class,
})
public class AllTests { }
