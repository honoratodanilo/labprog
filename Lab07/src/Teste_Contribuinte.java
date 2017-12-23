
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import principal.*;

import org.junit.Test;

/**
 * Classe de testes da classe abstrata Contribuinte.
 */
public class Teste_Contribuinte {

	Contribuinte c = null;
	
	@Test
	public void testaCriacaoContribuinte() {
		//testa cria��o passando o valor 'null' no par�metro 'nome'
		try {
			new Professor(null, 12345, true, true, 150000, 1500, 290);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O nome n�o pode ser vazio.", e.getMessage());
		}
		//testa cria��o passando uma String em branco no par�metro 'nome'
		try {
			new Professor("   ", 12345, true, true, 150000, 1500, 290);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O nome n�o pode ser vazio.", e.getMessage());
		}
		//testa cria��o passando um valor negativo no par�metro 'numeroDoContribuinte'
		try {
			new Professor("Jos�", -1, true, true, 150000, 1500, 290);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("N�mero de contribuinte inv�lido.", e.getMessage());
		}
		//testa cria��o passando o valor muito grande no par�metro 'numeroDoContribuinte' (Integer.MAX_VALUE+1)
		try {
			new Professor("Jos�", Integer.MAX_VALUE+1, true, true, 150000, 1500, 290);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("N�mero de contribuinte inv�lido.", e.getMessage());
		}
		//testa cria��o passando um valor negativo ao par�metro 'valorDosBens'
		try {
			new Professor("Jos�", 12345, true, true, -1, 1500, 290);
			fail("N�o deve cair aqui.");
		}catch(Exception e) {
			assertEquals("O valor dos bens n�o pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testeAtributosInicializados() {
		try {
			c = new Professor("Sebasti�o", 12345, true, true, 150000, 1650, 290);
		}catch(Exception e) {
			fail("N�o deve cair aqui");
		}
		assertEquals("Sebasti�o", c.getNome());
		assertEquals(12345, c.getNumeroDoContribuinte());
		assertEquals(true, c.temCasaPropria());
		assertEquals(true, c.temCarro());
		assertEquals(0, 150000, c.getValorDosBens());
	}
	
	@Test
	public void testeSinaisExterioresDeRiqueza() throws Exception {
		List<Contribuinte> lista = new ArrayList<Contribuinte>();
		lista.add(new Professor("Augusto", 001, true, true, 160000, 5500, 350));
		lista.add(new Professor("Madalena", 002, false, true, 20.000, 1.200, 90));
		lista.add(new Professor("Israel", 003, true, false, 50000, 1600, 120));
		lista.add(new Professor("Josefa", 004, true, true, 7000, 2100, 260));
		lista.add(new Professor("Sebasti�o", 005, false, true, 25000, 1550, 145));
		
		double mediaDosBens = Contribuinte.calculaMediaDosBensDeContribuintes(lista); //calcula m�dia dos bens dos contribuintes de uma categoria + 50% desse valor
		
		assertTrue(lista.get(0).sinaisExterioresDeRiquezaExcessivos(mediaDosBens)); //possui sinais exteriores de riqueza
		assertFalse(lista.get(1).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//n�o possui sinais exteriores de riqueza
		assertFalse(lista.get(2).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//n�o possui sinais exteriores de riqueza
		assertFalse(lista.get(3).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//n�o possui sinais exteriores de riqueza
		assertFalse(lista.get(4).sinaisExterioresDeRiquezaExcessivos(mediaDosBens));//n�o possui sinais exteriores de riqueza
		
		assertEquals(lista.size()+1, Contribuinte.numeroContribuintesCadastrados());
		//verifica a quantidade de Contribuintes inst�nciados (5 desse m�todo + 1 do m�todo anterior)
	}
}