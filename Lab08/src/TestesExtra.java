/*Aluno 1: Jo�o Victor*/
/*Aluno 2: Danilo Honorato*/

/**
 * Classe de testes extras.
 *
 */

public class TestesExtra {
    
    	public static void main(String[] args) throws Exception {
		Produto p = new Produto("Suco de laranja", 8.99);
		p.enviarComentarios("Danilo", "Excelente", 1);
		p.enviarComentarios("Luana", "Bom", 2);
		p.enviarComentarios("Jo�o", "Normal", 1);
		p.enviarComentarios("Carlos", "Muito bom", 1);
		p.enviarComentarios("Pablo", "Razo�vel", 2);
		p.enviarComentarios("Pedro", "Na m�dia, muito pequeno", -2);
		p.verComentariosEstrategiaSimples();
		p.verComentariosEstrategiaSazional();
	}
    
}