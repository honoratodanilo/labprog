/*Aluno 1: Jo�o Victor*/
/*Aluno 2: Danilo Honorato*/


/**
 * Classe faz a representa��o das caracter�sticas que um produto deve ter.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Produto implements NaMosca{
    
  private String descricao;
	private double preco;
	List<Comentarios> comentarios;
	
	/**
	 * Construtor da classe.
	 * @param descricao A descri��o do produto.
	 * @param preco O pre�o de venda do produto.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada seja inv�lida.
	 */
	public Produto(String descricao, double preco) throws Exception{
		comentarios = new ArrayList<>();
		setDescricao(descricao);
		setPreco(preco);
	}
	
	/**
	 * @return A descri��o do produto.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao A descri��o que ser� atribu�da ao produto.
	 * @throws Exception Ser� lan�ada caso nenhuma descri��o para o produto tiver sido passada.
	 */
	public void setDescricao(String descricao) throws Exception {
		if(descricao != null && !descricao.trim().isEmpty())
			this.descricao = descricao;
		else
			throw new Exception("O produto deve ter uma descri��o.");
	}

	/**
	 * @return O pre�o do produto.
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco O valor de venda que ser� atribu�do ao produto.
	 * @throws Exception Ser� lan�ada caso o valor passado seja menor ou igual a zero.
	 */
	public void setPreco(double preco) throws Exception {
		if(preco > 0)
			this.preco = preco;
		else
			throw new Exception("O produto deve ter um valor de venda maior que zero.");
	}

	/**
	 * Ver nota "NaMosca" com base na m�dia aritm�tica, e exibe coment�rios mais relevantes com base na maior nota e menor nota.
	 */
	@Override
	public void verComentariosEstrategiaSimples() {
		if(!comentarios.isEmpty()) {
			double mediaNotas = 0;
			Comentarios maiorAvaliacao = comentarios.get(0);
			Comentarios menorAvaliacao = comentarios.get(0);
			
			for(int i = 0; i < comentarios.size(); i++) {
				if(comentarios.get(i).getAvaliacao() > maiorAvaliacao.getAvaliacao()) {
					maiorAvaliacao = comentarios.get(i);
				}else if(comentarios.get(i).getAvaliacao() == maiorAvaliacao.getAvaliacao()) {
					if(maiorAvaliacao.getData().compareTo(comentarios.get(i).getData()) == 1)
						maiorAvaliacao = comentarios.get(i);
				}else if(comentarios.get(i).getAvaliacao() < menorAvaliacao.getAvaliacao()) {
					menorAvaliacao = comentarios.get(i);
				}else if(comentarios.get(i).getAvaliacao() == menorAvaliacao.getAvaliacao()) {
					if(menorAvaliacao.getData().compareTo(comentarios.get(i).getData()) == 1)
						menorAvaliacao = comentarios.get(i);
				}
				mediaNotas += comentarios.get(i).getAvaliacao();
			}
			System.out.println("Avalia��es");
			if(menorAvaliacao.getAvaliacao() != maiorAvaliacao.getAvaliacao()) {
				System.out.println("Menor Avalia��o:\n"+menorAvaliacao);
				System.out.println("\nMaior Nota:\n"+maiorAvaliacao);
			}else if(menorAvaliacao.getData().compareTo(maiorAvaliacao.getData()) == -1) {
				System.out.println(menorAvaliacao);
			}else {
				System.out.println(maiorAvaliacao);
			}
			System.out.printf("\nAvalia��o NaMosca: %,.1f\n", mediaNotas / comentarios.size());
		}else {
			System.out.println("Avalia��o NaMosca: 0\nSem coment�rios.");
		}	
	}
	
	/**
	 * Ver nota "NaMosca" e coment�rios com base nas avalia��es mais recentes.
	 */
	@Override
	public void verFeedbackEstrategiaSazional() {
		if(!comentarios.isEmpty()) {
			double mediaAvaliacoes = 0;
			int cont = 0;
			for(int i = comentarios.size()-1; (i >= 0 && i > comentarios.size()-4); i--, cont++) {
				mediaAvaliacoes += comentarios.get(i).getAvaliacao();
				if(cont < 2)
					System.out.println(comentarios.get(i)+"\n");
			}
			System.out.printf("Avalia��o NaMosca: %,.1f\n", mediaAvaliacoes /= cont);
		}else {
			System.out.println("Avalia��o NaMosca: 0\nSem coment�rios.");
		}
	}
	
	/**
	 * Adiciona um novo coment�rio feito por um consumidor ao produto.
	 */
	@Override
	public void enviarComentarios(String usuario, String comentario, int avaliacao) throws Exception {
		comentarios.add(new Comentarios(usuario, comentario, avaliacao));
	}
	
	/**
	 * Representa��o String do produto.
	 */
	@Override
	public String toString() {
		return String.format("Descri��o: %s\nPre�o: R$ %,.2f", getDescricao(), getPreco());
	}

	@Override
	public void verComentariosEstrategiaSazional() {
		// TODO Auto-generated method stub
		
	}  
    
}