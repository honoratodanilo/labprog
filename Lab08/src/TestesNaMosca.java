/*Aluno 1: Jo�o Victor*/
/*Aluno 2: Danilo Honorato*/


/**
 * Classe de testes NaMosca.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestesNaMosca {
    
Produto p = null;

	@Test
	public void testaCriacao() {
		//passando o valor 'null' como argumento para o par�metro 'descricao'
		try {
			p = new Produto(null, 1);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("O produto tem que ter uma descri��o.", e.getMessage());
		}
		//passando um Stringo em branco como argumento para o par�metro 'descricao'
		try {
			p = new Produto("  ", 1);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("O produto tem que ter uma descri��o.", e.getMessage());
		}
		//passando um valor negativo como argumento para o par�metro 'pre�o'
		try {
			p = new Produto("Sapato", -1);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("O produto tem que ter um valor de venda maior que zero.", e.getMessage());
		}
		//passando o valor zero como argumento para o par�metro 'pre�o'
		try {
			p = new Produto("Sapato", 0);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("O produto tem que ter um valor de venda maior que zero.", e.getMessage());
		}
		//cria��o do objeto passando valores v�lidos
		try {
			p = new Produto("Sapato", 199.00);
		}catch(Exception e) {
			fail("N�o pode entrar aqui.");
		}
	}
	
	@Test
	public void enviarComentarios(){
		//instanciando a refer�ncia a ser usada nos testes
		try {
			p = new Produto("AIRBUS A320", 69000);
		}catch(Exception e) {
			fail("N�o pode entrar aqui.");
		}
		//passando o valor 'null' como argumento para o par�metro 'comentario'
		try {
			p.enviarComentarios("Joyce", null, 2);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("Para avaliar o produto � necess�rio fornecer um comentario.", e.getMessage());
		}
		//passando uma String vazia como argumento para o par�metro 'comentario'
		try {
			p.enviarComentarios("Joyce", "", 2);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("Para avaliar o produto � necess�rio fornecer um comentario.", e.getMessage());
		}
		//passando uma String em branco como argumento para o par�metro 'comentario'
		try {
			p.enviarComentarios("Joyce", "    ", 2);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("Para avaliar o produto � necess�rio fornecer um comentario.", e.getMessage());
		}
		//passando uma String em branco como argumento para o par�metro 'comentario'
		String comentario141caracteres = "qwertyuiopa45687fghftyhfttyuiopasdfghjkl�z";
		try {
			p.enviarComentarios("Joyce", comentario141caracteres, 2);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("Seu comentario deve conter no m�ximo 140 caracteres.", e.getMessage());
		}
		//envio do comentario fornecendo notas fora do intervalo permitido -2 <= n <= 2
		try {
			p.enviarComentarios("Joyce", "O produto � maravilhoso!", -3);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("A nota atribu�da ao produto � inv�lida.", e.getMessage());
		}
		try {
			p.enviarComentarios("Joyce", "O produto � maravilhoso!", 3);
			fail("N�o pode entrar aqui.");
		}catch(Exception e) {
			assertEquals("A nota atribu�da ao produto � inv�lida.", e.getMessage());
		}
		//envio do comentario fornecendo valores v�lidos
		try {
			p.enviarComentarios("Joyce", "O produto � maravilhoso!", 2);
		}catch(Exception e) {
			fail("N�o pode entrar aqui.");
		}
	}    
    
    
}