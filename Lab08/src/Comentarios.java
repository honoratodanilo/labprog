/*Aluno 1: Jo�o Victor*/
/*Aluno 2: Danilo Honorato*/

/**
 * Classe que representa uma avalia��o a um produto.
 *
 */
import java.util.Calendar;

public class Comentarios {
    
   private String CONSUMIDOR_ANONIMO = "An�nimo";
	private String usuario;
	private String comentario;
	private int avaliacao;
	private Calendar data;
	
	/**
	 * @param usuario O nome do consumidor que avaliou o produto.
	 * @param comentario a descria��o do cliente ao produto.
	 * @param avaliacao A nota de avalia��o do cliente ao produto.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada seja inv�lida.
	 */
	public Comentarios(String usuario, String comentario, int avaliacao) throws Exception {
		setUsuario(usuario);
		setComentario(comentario);
		setAvaliacao(avaliacao);
		setData(data);
	}

	/**
	 * @return O nome do consumidor que avaliou o produto.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario O nome do consumidor que classificou o produto.
	 */
	public void setUsuario(String usuario) {
		if(usuario == null || usuario.trim().isEmpty()) {
			this.usuario = CONSUMIDOR_ANONIMO;
		}else {
			this.usuario = usuario;
		}
	}

	/**
	 * @return O coment�rio feito a um produto.
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario O coment�rio que ser� atribu�do ao produto.
	 * @throws Exception Ser� lan�ada uma exce��o caso o coment�rio tenha mais que 140 caracteres.
	 */
	public void setComentario(String comentario) throws Exception{
		if(comentario == null || comentario.length() == 0 || comentario.trim().isEmpty()) {
			throw new Exception("Para avaliar o produto � necess�rio fornecer um comentario.");
		}else if(comentario.length() > 140) {
			throw new Exception("Seu comentario deve conter no m�ximo 140 caracteres.");
		}else {
			this.comentario = comentario;
		}
	}

	/**
	 * @return A nota atribu�da ao produto.
	 */
	public int getAvaliacao() {
		return avaliacao;
	}

	/**
	 * @param avaliacao A nota que ser� atribu�da ao produto.
	 * @throws Exception Ser� lan�ada caso a nota/valor sej� inv�lido nota v�lida.
	 */
	public void setAvaliacao(int avaliacao) throws Exception {
		if(avaliacao >= -2 && avaliacao <= 2)
			this.avaliacao = avaliacao;
		else
			throw new Exception("A avalia��o feita do produto � inv�lida.");
	}

	/**
	 * @return A data de avalia��o do produto.
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data A refer�ncia na qual ser� atribu�da uma inst�ncia Calendar.
	 */
	private void setData(Calendar data) {
		this.data = Calendar.getInstance();
	}
	
	/**
	 * Retorna uma representa��o String do comentario do consumidor ao produto.
	 */
	@Override
	public String toString() {
		String string = String.format("Consumidor: %s\nNota: %d\nComentario: %s\n", getUsuario(), getAvaliacao(), getComentario());
		string = string.concat(String.format("Data da avalia��o: %02d/%02d/%d - %02d:%02d:%02d", data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH),
				data.get(Calendar.YEAR), data.get(Calendar.HOUR), data.get(Calendar.MINUTE), data.get(Calendar.SECOND)));
		return string;
	} 
    
}