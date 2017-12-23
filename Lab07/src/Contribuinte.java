import java.util.List;


/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

/**
 * Classe abstrata que define padr�es de todos contribuintes.
 */
public abstract class Contribuinte {

	private static int NUMERO_DE_CONTRIBUINTES_CADASTRADOS = 0;
	private String nome;
	private int numeroDoContribuinte;
	private boolean temCasaPropria = false;
	private boolean temCarro = false;
	private double valorDosBens;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param temCasaPropria Ser� passado true se o contribuinte tiver casa pr�pria, false se n�o tiver.
	 * @param temCarro Ser� passado true se o contribuinte tiver carro, false se n�o tiver.
	 * @param valorDosBens Valor somado de todos os bens do contribuinte.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada ao construtor seja inv�lida.
	 */
	public Contribuinte(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens) throws Exception{
		validaDados(nome, numeroDoContribuinte, valorDosBens);
		this.temCasaPropria = temCasaPropria;
		this.temCarro = temCarro;
		NUMERO_DE_CONTRIBUINTES_CADASTRADOS++;
	}

	/**
	 * Valida��o dos dados passados pelo usu�rio.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param valorDosBens Valor dos bens do contribuinte.
	 */
	private void validaDados(String nome, int numeroDoContribuinte, double valorDosBens) throws Exception{
		if(nome != null && !nome.trim().isEmpty()) {
			this.nome = nome;
		}else {
			throw new Exception("O nome n�o pode ser vazio.");
		}
		if(numeroDoContribuinte >= 0 && numeroDoContribuinte <= Integer.MAX_VALUE) {
			this.numeroDoContribuinte = numeroDoContribuinte;
		}else {
			throw new Exception("N�mero de contribuinte inv�lido.");
		}
		if(valorDosBens >= 0) {
			this.valorDosBens = valorDosBens;
		}else {
			throw new Exception("O valor dos bens n�o pode ser negativo.");
		}
	}
	
	/**
	 * Verifica se o sinal exterior de riqueza de um contribuinte � excessivo ou n�o, tomando como base a m�dia de todos os outros contribuintes de sua categoria.
	 * @param mediaDosContribuintes M�dia do valor dos bens dos contribuintes de uma mesma categoria.
	 * @return true caso o sinal de exterior de riqueza de um contribuinte seja excessivo, false se n�o for excessivo.
	 */
	public boolean sinaisExterioresDeRiquezaExcessivos(double mediaDosContribuintes) {
		double valorTotal = mediaDosContribuintes + (mediaDosContribuintes * 0.5);
		return valorDosBens > valorTotal;
	}
	
	/**
	 * M�todo est�tico que calcula a m�dia dos bens dos contribuintes de uma categoria e acrecenta 50% no valor m�dio.
	 * @return A m�dia dos bens dos contribuintes acrescido de 50% desse valor.
	 */
	public static double calculaMediaDosBensDeContribuintes(List<?> lista) {
		int somaDosBens=0;
		for(int i = 0; i < lista.size(); i++) {
			somaDosBens += ((Contribuinte)lista.get(i)).getValorDosBens();
		}
		double mediaDosBens = somaDosBens/lista.size();
		return mediaDosBens *= 1.5;
	}

	/**
	 * Retorna o nome do contribuinte.
	 * @return O nome do contribuinte.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o n�mero de cadastro do contribuinte.
	 * @return O n�mero de cadastro do contribuinte.
	 */
	public int getNumeroDoContribuinte() {
		return numeroDoContribuinte;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou n�o casa pr�pria.
	 * @return true se tiver casa pr�pria, false se n�o tiver.
	 */
	public boolean temCasaPropria() {
		return temCasaPropria;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou n�o carro.
	 * @return true se tiver carro, false se n�o tiver.
	 */
	public boolean temCarro() {
		return temCarro;
	}

	/**
	 * Retorna o valor somado de todos os bens do contribuintes.
	 * @return O valor total dos bens do contribuinte.
	 */
	public double getValorDosBens() {
		return valorDosBens;
	}
	
	/**
	 * M�todo est�tico que retorna o n�mero de contribuintes j� cadastrados no sistema.
	 * @return O n�mero de contribuintes j� cadastrados.
	 */
	public static int numeroContribuintesCadastrados() {
		return NUMERO_DE_CONTRIBUINTES_CADASTRADOS;
	}
	
	/**
	 * Faz o c�lculo devido do imposto a ser pago, sendo esse valor o tributo subtra�do do desconto referente a cada contribuinte.
	 * @return O valor de todos tributos subtra�do do desconto devido. Se o valor do desconto for maior que seus tributos, o contribuinte n�o paga imposto.
	 */
	public double calculaImpostoASerPago() {
		double imposto = calculaTributos();
		double desconto = calculaDesconto();
		return imposto < desconto ? 0 : (imposto-desconto);
	}
	
	/**
	 * M�todo abstrato que sugere o c�lculo dos tributos de cada contribuinte.
	 * @return O valor devido do imposto a ser pago.
	 */
	public abstract double calculaTributos();
	
	/**
	 * M�todo abstrato que sugere o c�lculo do desconto aplicado ao tributo de um contribuinte.
	 * @return O valor do desconto a ser aplicado sobre o tributo de um contribuinte.
	 */
	public abstract double calculaDesconto();
	
	/**
	 * Representa��o em String dos dados do contribuinte.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Profiss�o do contribuinte: "+getClass().getSimpleName());
		string.append("\nNome do contribuinte: "+nome);
		string.append("\nN� do contribuinte: "+numeroDoContribuinte);
		string.append(String.format("\nTem casa pr�pria: %s", temCasaPropria ? "Sim" : "N�o"));
		string.append(String.format("\nTem carro pr�prio: %s", temCarro ? "Sim" : "N�o"));
		string.append(String.format("\nValor total dos bens = R$ %,.2f", valorDosBens));
		return string.toString();
	}
}
