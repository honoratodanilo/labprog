
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

import java.util.List;
import java.util.ArrayList;

public class CD {
   
 private String artista;
	private String titulo;
	private String musicaPrincipal;
	private int numeroDeMusicas;
	private List<String> musicas;
	private final int QUANTIDADE_PADRAO = 10;
	
	/**
	 * Construtor que recebe o t�tulo e o artista do CD e define o n�mero de m�sicas padr�o = 10.
	 * @param titulo T�tulo do �lbum do artista.
	 * @param artista Artista compositor do CD.
	 * @throws Exception Ser� lan�ada um Exception caso algum argumento passado seja inv�lido.
	 */
	public CD(String titulo, String artista) throws Exception {
		validaInfos(titulo, artista);
		numeroDeMusicas = QUANTIDADE_PADRAO;
		musicas = new ArrayList<>(numeroDeMusicas);
	}
	
	/**
	 * Construtor que recebe o t�tulo, o artista o n�mero de m�sicas do CD.
	 * @param titulo T�tulo do �lbum do artista.
	 * @param artista Artista compositor do CD.
	 * @param quantMusicas N�mero de m�sicas que comp�em o CD.
	 * @throws Exception Ser� lan�ada um Exception caso algum argumento passado seja inv�lido.
	 */
	public CD(String titulo, String artista, int quantMusicas) throws Exception{
		validaInfos(titulo, artista);
		validaNumFaixas(quantMusicas);
		musicas = new ArrayList<>(this.numeroDeMusicas);
	}
	
	/**
	 * Verifica se o t�tulo e o artista passados s�o v�lidos.
	 * @param titulo T�tulo do CD passado como argumento para verifica��o.
	 * @param artista Artista do CD passado como argumento para verifica��o.
	 */
	private void validaInfos(String titulo, String artista) throws Exception{
		if(titulo != null && !titulo.trim().isEmpty()) {
			this.titulo = titulo;
		}else {
			throw new Exception("O CD tem que ter um t�tulo.");
		}
		if(artista != null && !artista.trim().isEmpty()) {
			this.artista = artista;
		}else {
			throw new Exception("O CD deve conter um artista criador.");
		}
	}
	
	/**
	 * @param numeroMusicas N�mero de m�sicas do CD passado para verifica��o.
	 * @throws Exception Ser� lan�ada uma exception caso o argumento passado seja inv�lido.
	 */
	private void validaNumFaixas(int quantMusicas) throws Exception{
		if(quantMusicas > 0) {
			this.numeroDeMusicas = quantMusicas;
		}else {
			throw new Exception("O �lbum n�o pode ser vazio.");
		}
	}
	
	/**
	 * @return O artista do CD.
	 */
	public String getArtista() {
		return artista;
	}
	
	/**
	 * Retorna o t�tulo do CD.
	 * @return O t�tulo do CD.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * @return A musica principal do CD.
	 */
	public String getFaixaPrincipal() {
		return musicaPrincipal;
	}
	
	/**
	 * @return O n�mero de m�sicas do CD.
	 */
	public int getNumeroMusicas() {
		return numeroDeMusicas;
	}
	
	/**
	 * @return Uma List com todas as m�sicas do CD.
	 */
	public List<String> getMusicas() {
		return musicas;
	}
	
	/**Muda a musica principal do CD caso o parametro seja valiodo.
	 * @param musica A m�sica que se deseja tornar a faixa principal do CD.
	 */
	public boolean alteraFaixaPrincipal(String musica) {
		if(musica != null && !musica.trim().isEmpty()) {
			for(int i = 0; i < musicas.size(); i++) {
				if(musica.equals(musicas.get(i))) {
					musicaPrincipal = musica;
					return true;
				}	
			}
		}
		return false;
	}
	
	/**
	 * Retorna a n-�sima faixa do CD, caso seja passado um n�mero entre 1 < N < n� total de faixas.
	 * @param indice Um �ndice (1 < N < n� total de m�sicas) da m�sica que deseja-se verificar.
	 * @return A m�sica da n-�sima posi��o pesquisada, ou null caso a mesma n�o esteja na lista.
	 */
	public String getMusica(int indice){
		if(indice >= 0 && indice < musicas.size()){
			return musicas.get(indice);
		}
		return null;
	}
	
	/**
	 * Cadastra uma nova m�sica no CD. At� o numero de faixas pr� determinado.
	 * @param musica A m�sica que se quer inserir no CD.
	 * @return true se a m�sica for adicionada, false caso n�o seja poss�vel adicion�-la a lista de m�sicas.
	 */
	public boolean cadastrarMusica(String musica) {
		if(musica != null && !musica.trim().isEmpty() && musicas.size() < numeroDeMusicas) {
			return musicas.add(musica);
		}
		return false;
	}
	
	/**
	 * Compara dois CD's, para ver se s�o identicos.
	 */
	@Override
	public boolean equals(Object cd) {
		if(cd instanceof CD && cd != null) {
			CD cdAux = (CD) cd;
			if(getArtista().equals(cdAux.getArtista()) && getTitulo().equals(cdAux.getTitulo()))
				return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma representa��o em String do CD.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Artista: "+getArtista());
		string.append("\nT�tulo: "+getTitulo());
		string.append("\nMusica principal: "+getFaixaPrincipal());
		string.append("\n\nLista de m�sicas: ");
		for(int i = 0; i < musicas.size(); i++) {
			string.append(String.format("\n%02d - %s", i+1, getMusica(i)));
		}
		return string.toString();
	}   
            
}