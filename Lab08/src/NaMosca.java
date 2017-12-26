/*Aluno 1: Jo�o Victor*/
/*Aluno 2: Danilo Honorato*/

/**
 * Interface que determina o que o sistema deve oferecer ao usu�rio para madifica��o dos coment�rios feitos.
 */

public interface NaMosca {
   
   /**
	 * Mostra a nota do "NaMosca" com base na m�dia aritm�tica das notas, e exibe os coment�rios mais relevantes da maior nota e menor nota.
	 */
	void verComentariosEstrategiaSimples();
	
	/**
	 * Ver nota "NaMosca" e coment�rios com base nas ultimas avalia��es.
	 */
	void verComentariosEstrategiaSazional();
	
	/**
	 * @param usuario O nome do consumidor.
	 * @param comentario O coment�rio feito pelo usuario.
	 * @param avaliacao A nota atribu�da pelo usuario a um produto.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada seja inv�lida.
	 */
	void enviarComentarios(String usuario, String comentario, int avaliacao) throws Exception;

	void verFeedbackEstrategiaSazional(); 
    
}