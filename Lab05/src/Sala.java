/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
 * Aluno 03: Fernanda Medeiros
 */

/**
 * Classe que simula uma sala Real.
 * @version 1.0 - Last Modified: 22/12/2017 14:00
 */
public class Sala extends Exception{
	
	private static final long serialVersionUID = 1L;
	private int[][] sala;
	public static final int LIVRE = 0;
	public static final int OCUPADO = 1;
	
	/**
	 * Construtor da classe Sala.
	 * @param linhas N�mero de linhas da sala.
	 * @param colunas N�mero de colunas da sala.
	 * @throws Exception Ser� lan�ada caso sejam passados valores inv�lidos.
	 */
	public Sala(int linhas, int colunas) throws Exception{
		validaDimensoes(linhas, colunas);
	}
	
	/**
	 * Valida e atribui as dimens�es da sala.
	 * @param linhas N�meros de linhas da sala.
	 * @param colunas N�mero de colunas da sala.
	 * @return boolean (true) caso os valores passados sejam v�lidos.
	 * @throws Exception Ser� lan�ada caso sejam passados valores inv�lidos.
	 */
	private void validaDimensoes(int linhas, int colunas) throws Exception{
		if(linhas > 0 && colunas > 0) {
			sala = new int[linhas][colunas];
		}else {
			throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
		}
	}

	/**
	 * A dimens�o horizontal da sala.
	 * @return A quantidade de "linhas" que a Sala tem.
	 */
	public int getNumPosicoesHorizontais() {
		return sala.length;
	}

	/**
	 * A dimens�o vertical da Sala.
	 * @return A quantidade de "colunas" que a Sala tem.
	 */
	public int getNumPosicoesVerticais() {
		return sala[0].length;
	}
	
	/**
	 * Verifica se a sala est� vazia.
	 * @return Um boolean que retornar� true caso a sala esteja vazia, e false se tiver algum objeto na sala.
	 */
	public boolean isVazia() {
		for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
			for(int j = 0; j < getNumPosicoesVerticais(); j++) {
				if(sala[i][j] == Sala.OCUPADO) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Insere um obst�culo a sala.
	 * @param linha A primeira coordenada do obst�culo.
	 * @param coluna A segunda coordenada do obst�culo.
	 * @return true caso o obst�culo tiver sido fixado na sala, e false caso n�o tenha sido fixado.
	 * @throws Exception 
	 */
	public boolean inserirObstaculo(int linha, int coluna) throws Exception{
			if(isPosicaoLivre(linha, coluna)) {
				sala[linha][coluna] = Sala.OCUPADO;
				return true;
			}
		return false;
	}

	/**
	 * Verifica se a posi��o passada em v�lida com base nas dimens�es da sala.
	 * @param linha A primeira coordenada da sala.
	 * @param coluna A segunda coordenada da sala.
	 * @return true case for uma posi��o v�lida e false caso n�o seja.
	 */
	public boolean posicaoValida(int linha, int coluna){
		if((linha >= 0 && linha < sala.length) && (coluna >= 0 && coluna < sala[0].length)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a posi��o passada est� livre.
	 * @param linha Linha da sala.
	 * @param coluna Coluna da sala.
	 * @return true case esteja livre e false caso n�o esteja.
	 */
	public boolean isPosicaoLivre(int linha, int coluna) throws Exception{
		if(posicaoValida(linha, coluna)) {
			return sala[linha][coluna] == Sala.LIVRE;
		}
		throw new Exception("Posicao inexistente.");
	}
	
	/**
	 * Atribui um novo "status" (LIVRE ou OCUPADO) a uma posi��o da sala.
	 * @param linha Linha na qual se deseja atribuir o novo status.
	 * @param coluna Coluna na qual se deseja atribuir o novo status.
	 * @param status O status que ir� ser atribu�do a uma posi��o da sala (LIVRE ou OCUPADO).
	 * @return true caso seja atribu�do com sucesso, false no caso de falha.
	 */
	public boolean setPosicao(int linha, int coluna, int status) {
		if(posicaoValida(linha, coluna)) {
			sala[linha][coluna] = status;
			return true;
		}
		return false;
	}
	
	/**
	 * Compara se duas salas s�o iguais, levando em conta suas dimens�es e suas ocupa��es em cada posi��o.
	 */
	@Override
	public boolean equals(Object outraSala) {
		if(!(outraSala == null)) {
			Sala salaAux = (Sala)outraSala;
			if(getNumPosicoesHorizontais() == salaAux.getNumPosicoesHorizontais() && getNumPosicoesVerticais() == salaAux.getNumPosicoesVerticais()) {
				for(int i = 0; i < getNumPosicoesHorizontais(); i++) {
					for(int j = 0; j < getNumPosicoesVerticais(); j++) {
						if(sala[i][j] != salaAux.sala[i][j]) {
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}
}
