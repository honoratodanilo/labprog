
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;


public class TestaMinhaCDteca {
        
 MinhaCDteca cdteca;
	List<CD> cds;
	CD cd;
	
	@Before
	public void criaCDteca() throws Exception {
		cdteca = new MinhaCDteca(); //inst�ncia um objeto MinhaCDteca
		cds = new ArrayList<CD>();
		cds.add(new CD("Piano Bar", "Engenheiros do Hawaii"));
		cds.add(new CD("Pose", "Dom Quixote"));
		cds.add(new CD("Evanescence", "Beatles"));
		cdteca.adicionaCDs(cds); //adiciona uma lista de CD's a cdteca por meio do m�todo adicionaCDs(List<CD> cds)
		cd = new CD("In the end", "Xero");
		cdteca.adicionaCD(cd); //adiciona um CD a cdteca por meio do m�todo adicionaCD(CD cd)
	}

	@Test
	public void testaRemocao() throws Exception {
		//tenta remover um CD que n�o est� na cole��o
		try {
			cdteca.removeCD("The Wall.");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("Este CD n�o est� na cole��o da CDteca.", e.getMessage());
		}
		//remove um CD que est� na cole��o
		try {
			assertEquals(cd, cdteca.removeCD("In the end"));
		}catch(Exception e) {
			fail("N�o deve cair aqui.");
			e.printStackTrace();
		}
		
		List<CD> lista1 = new ArrayList<CD>();
		lista1.add(new CD("In the end", "Engenheiros do Hawaii"));
		lista1.add(new CD("The Wall", "Artista desconhecido"));
		//nenhum desses t�tulos est� na lista, pois "Led Zeppelin IV j� foi removido anteriormente...
		assertFalse(cdteca.removeCDs(lista1)); //logo, deve retorna false.
		
		List<CD> lista2 = new ArrayList<CD>();
		lista2.add(new CD("Evanescence", "Beatles"));
		lista2.add(new CD("The Wall", "Artista desconhecido"));
		//cont�m um t�tulo que est� na lista...
		assertTrue(cdteca.removeCDs(lista2)); //ent�o deve retornar true.
		
		List<CD> lista3 = new ArrayList<CD>();
		lista3.add(new CD("Pose", "Dom Quixote"));
		lista3.add(new CD("Evanescence", "Beatles"));
		//todos t�tulos est�o na lista...
		assertTrue(cdteca.removeCDs(lista3)); //ent�o todos ser�o removidos.
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "N�o � uma cdteca.";
		assertFalse(cdteca.equals(obj)); //testa o equals passando um objeto diferente
		assertFalse(cdteca.equals(null)); //testa o equals passando o valor null
		MinhaCDteca outraCDteca = new MinhaCDteca();
		assertFalse(cdteca.equals(outraCDteca)); //testa o equals passando uma cdteca diferente (est� vazia)
		outraCDteca.adicionaCDs(cds); //adiciona uma lista de cd's a nova cdteca
		outraCDteca.adicionaCD(cd); //adiciona mais um cd a cdteca nova
		System.out.println(cdteca);
		System.out.println(outraCDteca);
		assertTrue(cdteca.equals(outraCDteca)); //testa o equals passando uma cdteca igual, pois foram adicionados os mesmos CD's
		outraCDteca.adicionaCD(cd); //adiciona um outro cd (repetido) na nova biblioteca...
		assertTrue(cdteca.equals(outraCDteca)); //continua sendo igual a outra cdteca, por�m com um cd repetido
		System.out.println(cdteca);
		System.out.println(outraCDteca);
		outraCDteca.adicionaCD(new CD("The Wall", "Autor desconhecido")); //adiciona um cd diferente a nova cdteca...
		assertFalse(cdteca.equals(outraCDteca)); //agora as cdtecas s�o diferentes.
		System.out.println(cdteca);
		System.out.println(outraCDteca);
	}
	
	@Test
	public void outrosTestes() throws Exception {
		assertEquals(4, cdteca.numeroDeCDs()); //testa se o n�mero de cds cadastrados est� correto
		assertEquals(null, cdteca.pesquisaCD("The Wall")); //pesquisa uma CD que n�o est� na cdteca
		assertEquals(cd, cdteca.pesquisaCD("In the end")); //pesquisa um CD que est� na cdteca, retornando o mesmo
		assertTrue(cdteca.removeCDs(cds)); //remove uma lista de CD's
		assertEquals(cd, cdteca.removeCD("In the end")); //remove mais um CD
		assertEquals(0, cdteca.numeroDeCDs()); //agora a cdteca est� vazia
		assertEquals(null, cdteca.pesquisaCD("In the end")); //ent�o n�o h� mais esse CD na cdteca
	}   
    
    
}
