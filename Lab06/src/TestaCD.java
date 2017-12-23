
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestaCD {
    
 CD cd = null;
	int NUMERO_DE_MUSICAS_CD = 12;
	String[] colecaoDeMusicas = {"Piano Bar", "Refr�o de Bolero", "Pra Ser Sincero", "Dom Quixote", "3x4", 
	"Somos Quem Podemos Ser", "Infinita Highway", "Eu Que N�o Amo Voc�", "Perfeita Simetria", "At� o Fim",
	"Terra de Gigantes", "O Papa � Pop", "Pose"}; //array com 13 m�sicas
	
	@Before
	public void criaCD() throws Exception {
		cd = new CD("Piano Bar", "Engenheiros do Hawaii", NUMERO_DE_MUSICAS_CD); //inst�cia um objeto CD
	}
	
	@Test
	public void testaCriacao() {
		//tenta criar um CD passando null como argumento para o par�metro t�tulo
		try {
			cd = new CD(null, "Meteora");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um t�tulo.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o par�metro t�tulo
		try {
			cd = new CD("   ", "Xero");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um t�tulo.", e.getMessage());
		}
		//tenta criar um CD passando null como argumento para o par�metro artista
		try {
			cd = new CD("Meteora", null);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando uma String em branco como argumento para o par�metro artista
		try {
			cd = new CD("Meteora", "   ");
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O CD deve conter um artista.", e.getMessage());
		}
		//tenta criar um CD passando um valor negativo como argumento para o par�metro quantMusicas
		try {
			cd = new CD("Meteora", "Xero", -2);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O �lbum n�o pode ser vazio.", e.getMessage());
		}
		//tenta criar um CD passando zero como argumento para o par�metro quantMusicas
		try {
			cd = new CD("Meteora", "Xero", 0);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O �lbum n�o pode ser vazio.", e.getMessage());
		}
	}
	
	@Test
	public void testaEstadoInicial() {
		assertEquals("Piano Bar", cd.getArtista()); //confere se o artista foi "setado" corretamente
		assertEquals("Numb", cd.getTitulo()); //confere se o titulo do CD foi "setado" corretamente
		assertEquals(null, cd.getFaixaPrincipal()); //retorna null j� que ainda n�o foi atribu�do nenhuma m�sica ao CD
		assertEquals(NUMERO_DE_MUSICAS_CD, cd.getNumeroMusicas()); //confere se o n�mero de m�sicas foi "setado" corretamente
		assertEquals(null, cd.getMusica(0)); //retorna null j� que o CD ainda est� vazio
	}
	
	@Test
	public void testaCadastroDeMusicas() {
		assertFalse(cd.alteraFaixaPrincipal("Piano Bar")); //Ainda n�o tem nenhuma m�sica cadastrada.
		assertFalse(cd.cadastrarMusica(null)); //Tenta atribuir null a faixa principal
		assertFalse(cd.cadastrarMusica("     ")); //Tenta atribuir uma String em branco a faixa principal
		for(int i = 0; i < cd.getNumeroMusicas(); i++) {
			assertTrue(cd.cadastrarMusica(colecaoDeMusicas[i]));
		} //cadastra 10 m�sicas no CD
		assertFalse(cd.cadastrarMusica(colecaoDeMusicas[cd.getNumeroMusicas()])); //tenta cadastrar mais uma m�sica, por�m, j� chegou ao limite permitido
		assertTrue(cd.alteraFaixaPrincipal("Piano Bar")); //altera a faixa principal (a m�sica est� na lista)
		assertFalse(cd.alteraFaixaPrincipal("Numb")); //tentativa de alterar a faixa principal (a m�sica n�o est� na lista)
		assertFalse(cd.alteraFaixaPrincipal(null)); //novamente uma tentativa de atribuir null a faixa principal
		assertFalse(cd.alteraFaixaPrincipal("    ")); //novamente uma tentativa de atribuir uma String em branco a faixa principal
	}
	
	@Test
	public void testaEquals() throws Exception {
		String obj = "N�o � um CD";
		assertFalse(cd.equals(obj)); //testa o equals com outro objeto
		assertFalse(cd.equals(null)); //testa o equals passando null
		CD novoCD = new CD("Novo CD", "Testando Equals"); 
		assertFalse(cd.equals(novoCD)); //testa o equals passando um CD diferente
		novoCD = new CD("Engenheiros do Hawaii", "Linkin Park");
		assertTrue(cd.equals(novoCD)); //testa o equals passando um CD igual
	}   
    
}