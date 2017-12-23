
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import static org.junit.Assert.*;

import org.junit.Test;

import principal.Caminhoneiro;

/**
 * Classe de testes da classe Caminhoneiro.
 */
public class Teste_Caminhoneiro {

	@Test
	public void testaCriacao() {
		//instancia��o do objeto Caminhoneiro passando um valor inv�lido ao par�metro 'quilometragemPercorrida'
		try {
			new Caminhoneiro("Sebasti�o", 12345, true, true, 150000, -150, 1000);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("Valor da quilometragem inv�lido.", e.getMessage());
		}
		//instancia��o do objeto Caminhoneiro passando um valor inv�lido ao par�metro 'toneladasTransportadas'
		try {
			new Caminhoneiro("Sebasti�o", 12345, true, true, 150000, 12000, -500);
			fail("N�o deve cair aqui.");
		} catch (Exception e) {
			assertEquals("O n�mero de toneladas transportadas n�o pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Caminhoneiro caminhoneiro = new Caminhoneiro("Ivan Simpl�cio", 12345, true, true, 150000, 10000, 10);
		assertEquals(500, caminhoneiro.calculaTributos(), 0); // tributos calculados: TAXA_FIXA at� 10T = 500
		assertEquals(100, caminhoneiro.calculaDesconto(), 0); // descontos calculados: 10000 * 0,01 = 100
		assertEquals(400, caminhoneiro.calculaImpostoASerPago(), 0); // imposto a ser pago: 500 - 100 = 400
		caminhoneiro = new Caminhoneiro("Ivan Simpl�cio", 12345, true, true, 150000, 22000, 22);
		assertEquals(1700, caminhoneiro.calculaTributos(), 0); // tributos calculados: TAXA_FIXA + 12 * 100 = 1700
		assertEquals(220, caminhoneiro.calculaDesconto(), 0); // descontos calculados: 5000 * 0,01 = 220
		assertEquals(1480, caminhoneiro.calculaImpostoASerPago(), 0); // imposto a ser pago: 1700-220 = 1480
	}
}