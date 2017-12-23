/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
 * Aluno 03: Fernanda Medeiros
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes da classe Robo.
 */
public class TestaRobo{

	private Sala sala = null;
	private Robo robo = null;
	private int ENERGIA_PADRAO = 10;
	private int LINHA = 3;
	private int COLUNA = 3;
	
	public Sala criaSala() throws Exception{
		return new Sala(LINHA, COLUNA);
	}
	
	public void preencheSala(Sala sala) {
		for(int i = 0; i < sala.getNumPosicoesHorizontais(); i++) {
			for(int j = 0; j < sala.getNumPosicoesVerticais(); j++) {
				sala.setPosicao(i, j, Sala.OCUPADO);
			}
		}
	}
	
	@Before
	public void criaRobo() throws Exception {
		sala = criaSala();
		robo = new Robo(sala, ENERGIA_PADRAO);
	}
	
	@Test
	public void testaCriacaoRobo() {
		try {
			Assert.assertTrue(robo.isPosicaoAtual(0, 0));
			Assert.assertFalse(sala.isPosicaoLivre(0, 0));
		}catch(Exception e) {
			Assert.fail("N�o pode entrar aqui!");
		}
		try {
			sala = criaSala();
			sala.inserirObstaculo(0, 0);
			robo = new Robo(sala, ENERGIA_PADRAO);
		}catch(Exception e) {
			Assert.fail("N�o pode entrar aqui!");
		}
		Assert.assertTrue(robo.isPosicaoAtual(0, 1));

		try {
			new Robo(criaSala(), ENERGIA_PADRAO);
		}catch(Exception e) {
			Assert.fail("N�o pode entrar aqui!");
			e.printStackTrace();
		}
		try {
			new Robo(criaSala(), -1);
			Assert.fail("A energia n�o pode ser negativa.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "N�o � poss�vel criar um robo com energia menor ou igual zero.", e.getMessage());
		}
		try {
			new Robo(criaSala(), 0);
			Assert.fail("A sala passada est� cheia.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "N�o � poss�vel criar um robo com energia menor ou igual zero.", e.getMessage());
		}
		try {
			new Robo(null, ENERGIA_PADRAO);
			Assert.fail("N�o pode ser passado null no par�metro sala");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "Nenhuma sala passada ao robo.", e.getMessage());
		}
		try {
			Sala salaAux = criaSala();
			preencheSala(salaAux);
			new Robo(salaAux, ENERGIA_PADRAO);
			Assert.fail("A sala passada est� cheia.");
		}catch(Exception e) {
			Assert.assertEquals("Mensagem errada", "A sala passada est� cheia, n�o � poss�vel posicionar o robo nesta sala.", e.getMessage());
		}	
	}
	
	@Test
	public void testaMovimentosIniciaisRobo() throws Exception {
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertFalse(sala.isPosicaoLivre(0, 0));
		Assert.assertFalse(robo.praTras());
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(ENERGIA_PADRAO, robo.energiaAtual());
		Assert.assertEquals(0, robo.numeroPassos());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(1,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		
		try {
			sala = criaSala();
			sala.inserirObstaculo(0, 0);
			robo = new Robo(sala, ENERGIA_PADRAO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
	}
	
	@Test
	public void testaMovimentosComObstaculos() throws Exception {
		sala.inserirObstaculo(1, 0);
		sala.inserirObstaculo(0, 2);
		Assert.assertFalse(robo.praFrente());
		Assert.assertEquals(ENERGIA_PADRAO, robo.energiaAtual());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(ENERGIA_PADRAO-1, robo.energiaAtual());
		Assert.assertFalse(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(0,1));
		Assert.assertEquals(1, robo.numeroPassos());
		Assert.assertEquals(ENERGIA_PADRAO-1, robo.energiaAtual());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertEquals(2, robo.numeroPassos());
		Assert.assertEquals(ENERGIA_PADRAO-2, robo.energiaAtual());
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(1,2));
		Assert.assertEquals(ENERGIA_PADRAO-3, robo.energiaAtual());
		Assert.assertEquals(3, robo.numeroPassos());
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		Assert.assertFalse(robo.esquerda());
		Assert.assertEquals(ENERGIA_PADRAO-4, robo.energiaAtual());
		Assert.assertEquals(4, robo.numeroPassos());
	}
	
	@Test
	public void testeEmSalaVazia() {
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.praFrente());
		Assert.assertEquals(ENERGIA_PADRAO-3, robo.energiaAtual());
		Assert.assertEquals(3, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(2,1));
		
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.esquerda());
		Assert.assertEquals(ENERGIA_PADRAO-6, robo.energiaAtual());
		Assert.assertEquals(6, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(1,1));
		
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.praTras());
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.esquerda());
		Assert.assertEquals(0, robo.energiaAtual());
		Assert.assertEquals(10, robo.numeroPassos());
		Assert.assertTrue(robo.isPosicaoAtual(0,0));
		
		Assert.assertFalse(robo.direita());
		Assert.assertEquals(0, robo.energiaAtual());
	}
	
	@Test
	public void testarQuinas() {
		Assert.assertTrue(robo.direita());
		Assert.assertTrue(robo.direita());
		Assert.assertFalse(robo.direita());
		Assert.assertFalse(robo.praTras());
		Assert.assertTrue(robo.isPosicaoAtual(0,2));
		Assert.assertEquals(ENERGIA_PADRAO-2, robo.energiaAtual());
		Assert.assertEquals(2, robo.numeroPassos());
		
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.praFrente());
		Assert.assertFalse(robo.praFrente());
		Assert.assertFalse(robo.direita());
		Assert.assertTrue(robo.isPosicaoAtual(2,2));
		Assert.assertEquals(ENERGIA_PADRAO-4, robo.energiaAtual());
		Assert.assertEquals(4, robo.numeroPassos());
		
		Assert.assertTrue(robo.esquerda());
		Assert.assertTrue(robo.esquerda());
		Assert.assertFalse(robo.esquerda());
		Assert.assertFalse(robo.praFrente());
		Assert.assertTrue(robo.isPosicaoAtual(2,0));
		Assert.assertEquals(ENERGIA_PADRAO-6, robo.energiaAtual());
		Assert.assertEquals(6, robo.numeroPassos());
	}
	
	@Test
	public void testaEquals() throws Exception {
		Sala sala2 = null;
		Robo robo2 = null;
		Assert.assertFalse(robo.equals(robo2));
		try {
			sala2 = new Sala(10, 10);
			robo2 = new Robo(sala2, ENERGIA_PADRAO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(robo.equals(robo2));
		
		try{
			sala2 = criaSala();
			robo2 = new Robo(sala2, ENERGIA_PADRAO);
		}catch(Exception e){
			e.printStackTrace();
		}
		Assert.assertTrue(robo.equals(robo2));
		Assert.assertTrue(sala2.inserirObstaculo(0, 1));
		Assert.assertFalse(robo.equals(robo2));
		Assert.assertTrue(sala.inserirObstaculo(0, 1));
		Assert.assertTrue(robo.equals(robo2));
		Assert.assertTrue(robo2.praFrente());
		Assert.assertFalse(robo.equals(robo2));
		Assert.assertTrue(robo.praFrente());
		Assert.assertTrue(robo.equals(robo2));
	}
}
