
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import static org.junit.Assert.*;
import org.junit.Test;
import principal.Medico;

/**
 * Classe de testes da classe Medico.
 */
public class Teste_Medico {

	@Test
	public void testaCriacao() {
		//instancia��o do objeto Medico passando um valor inv�lido ao par�metro 'numeroDePacientesAtendidos'
		try {
			new Medico("Sebasti�o", 12345, true, true, 150000, -1, 1500);
			fail("N�o deve cair aqui");
		}catch(Exception e) {
			assertEquals("O n�mero de pacientes atendidos pelo m�dico n�o pode ser negativo.", e.getMessage());
		}
		//instancia��o do objeto Medico passando um valor inv�lido ao par�metro 'gastosEmCongressos'
		try {
			new Medico("Sebasti�o", 12345, true, true, 150000, 100, -100);
			fail("N�o deve cair aqui");
		} catch (Exception e) {
			assertEquals("O total de gastos em congressos do m�dico n�o pode ser negativo.", e.getMessage());
		}
	}
	
	@Test
	public void testaTributacaoEDescontos() throws Exception {
		Medico medico = new Medico("Ivan Simpl�cio", 12345, true, true, 150000, 100, 560);
		assertEquals(1000, medico.calculaTributos(), 0); // tributos calculados: 100 * 10 = 1000
		assertEquals(560, medico.calculaDesconto(), 0); // descontos calculados: gastos = 560
		assertEquals(440, medico.calculaImpostoASerPago(), 0); // imposto a ser pago: 1000 - 560 = 440
		medico = new Medico("Ivan Simpl�cio", 12345, true, true, 150000, 125, 620);
		assertEquals(1250, medico.calculaTributos(), 0); // tributos calculados: 125 * 10 = 1250
		assertEquals(620, medico.calculaDesconto(), 0); // descontos calculados: gastos = 620
		assertEquals(630, medico.calculaImpostoASerPago(), 0); // imposto a ser pago: 1250 - 620 = 630
	}
}