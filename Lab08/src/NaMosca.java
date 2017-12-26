/*Aluno 1: João Victor*/
/*Aluno 2: Danilo Honorato*/

/**
 * Interface que determina o que o sistema deve oferecer ao usuário para madificação dos comentários feitos.
 */

public interface NaMosca {
   
   /**
	 * Mostra a nota do "NaMosca" com base na média aritmética das notas, e exibe os comentários mais relevantes da maior nota e menor nota.
	 */
	void verComentariosEstrategiaSimples();
	
	/**
	 * Ver nota "NaMosca" e comentários com base nas ultimas avaliações.
	 */
	void verComentariosEstrategiaSazional();
	
	/**
	 * @param usuario O nome do consumidor.
	 * @param comentario O comentário feito pelo usuario.
	 * @param avaliacao A nota atribuída pelo usuario a um produto.
	 * @throws Exception Será lançada caso alguma informação passada seja inválida.
	 */
	void enviarComentarios(String usuario, String comentario, int avaliacao) throws Exception;

	void verFeedbackEstrategiaSazional(); 
    
}