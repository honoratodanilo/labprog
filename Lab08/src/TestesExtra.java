/*Aluno 1: João Victor*/
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
		p.enviarComentarios("João", "Normal", 1);
		p.enviarComentarios("Carlos", "Muito bom", 1);
		p.enviarComentarios("Pablo", "Razoável", 2);
		p.enviarComentarios("Pedro", "Na média, muito pequeno", -2);
		p.verComentariosEstrategiaSimples();
		p.verComentariosEstrategiaSazional();
	}
    
}