
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

/**
 * Classe que cont�m uma cole��o de CD's com m�todos para manipul�-los.
 * @author Adenou
 */

import java.util.ArrayList;
import java.util.List;


public class MinhaCDteca {
    
 private List<CD> colecaoDeCDs;
	private int variedade;
	
	/**
	 * Contrutor que instancia um cole��o do CD's.
	 */
	public MinhaCDteca() {
		colecaoDeCDs = new ArrayList<CD>();
		variedade = 0;
	}
	
	/**.
	 * @param novoCD Um CD que ser� adicionado a cole��o.
	 */
	public void adicionaCD(CD novoCD) {
		int cont=0;
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			if(!novoCD.getTitulo().equals(colecaoDeCDs.get(i).getTitulo()))
				cont++;
		}
		if(cont == numeroDeCDs())
			variedade++;
		colecaoDeCDs.add(novoCD);
	}
	
	/**
	 * Adiciona uma lista de CD's na cole��o de CD's.
	 * @param listaCDs Uma List<CD> que ser� adicionada a cole��o.
	 */
	public void adicionaCDs(List<CD> listaCDs) {
		for(int i = 0; i < listaCDs.size(); i++) {
			adicionaCD(listaCDs.get(i));
		}
	}
	
	/**
	 * Remove um CD da lista de CD's a partir do t�tulo do CD.
	 * @param titulo O t�tulo do CD que se quer remover.
	 * @return O CD removido, ou null se n�o tiver sido encontrado.
	 * @throws Exception Ser� lan�ada caso o CD que o usu�rio esteja tentando remover n�o esteja na cole��o.
	 */
	public CD removeCD(String titulo) throws Exception{
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			if(titulo.equals(colecaoDeCDs.get(i).getTitulo())) {
				return colecaoDeCDs.remove(i);
			}
		}
		throw new Exception("Este CD n�o est� na discografia.");
	}
	
	/**
	 * @param titulos Uma List<CD> com os CD's que se deseja remover.
	 * @return true se pelo menos um CD for removido, false se n�o remover nenhum CD da cole��o.
	 */
	public boolean removeCDs(List<CD> listaCDs) {
		int cont = 0;
		for(int i = 0; i < listaCDs.size(); i++) {
			try {
				removeCD(listaCDs.get(i).getTitulo());
				cont++;
			}catch(Exception e) {
			}
		}
		if(cont != 0)
			return true;
		return false;
	}
	
	/**
	 * Pesquisa um CD na discografia de CD's com base no t�tulo.
	 * @param titulo O t�tulo do CD procurado.
	 * @return O CD caso ele esteja na cole��o ou null se n�o o achar.
	 */
	public CD pesquisaCD(String titulo) {
		for(int i = 0; i < colecaoDeCDs.size(); i++)
			if(titulo.equals(colecaoDeCDs.get(i).getTitulo()))
				return colecaoDeCDs.get(i);
		return null;
	}
	
	/**
	 * @return O n�mero de CD's que existem na discografia.
	 */
	public int numeroDeCDs() {
		return this.colecaoDeCDs.size();
	}
	
	/**
	 * Compara as cole��es de CD's para ver uma � igual a outra.
	 */
	@Override
	public boolean equals(Object outraBiblioteca) {
		if(outraBiblioteca instanceof MinhaCDteca && outraBiblioteca != null) {
			MinhaCDteca auxCDteca = (MinhaCDteca) outraBiblioteca;
			if(variedade == auxCDteca.variedade) {
				for(int i = 0; i < colecaoDeCDs.size(); i++) {
					if(auxCDteca.pesquisaCD(colecaoDeCDs.get(i).getTitulo()) == null) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @retorn uma representa��o da String da cole��o de CD's.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Lista de CD's da discografia: ");
		for(int i = 0; i < colecaoDeCDs.size(); i++) {
			string.append(String.format("\n\nCD %02d", i+1));
			string.append("\nArtista: "+colecaoDeCDs.get(i).getArtista());
			string.append("\nT�tulo: "+colecaoDeCDs.get(i).getTitulo());
		}
		return string.toString();
	}
    
}