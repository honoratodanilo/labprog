
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

/**
 * Classe que define um taxista.
 */
public class Taxista extends Rodoviario{

	private int numeroDePassageiros;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do taxista.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param temCasaPropria Ser� passado true se o taxista tiver casa pr�pria, false se n�o tiver.
	 * @param temCarro Ser� passado true se o taxista tiver carro, false se n�o tiver.
	 * @param valorDosBens Valor somado de todos os bens do taxista.
	 * @param quilometragemPercorrida Total de quil�metros percorridos pelo taxista.
	 * @param numeroDePassageiros N�mero de passageiros transportados pelo taxista.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada ao construtor seja inv�lida.
	 */
	public Taxista(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida, int numeroDePassageiros) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens, quilometragemPercorrida);
		setNumeroDePassageiros(numeroDePassageiros);
	}

	/**
	 * Verifica se o n�mero de passageiros passado como argumento � v�lido.
	 * @param numeroDePassageiros O n�mero de passageiros que ser� validado.
	 * @throws Exception Ser� lan�ada caso o n�mero de passageiros passado seja inv�lido.
	 */
	private void setNumeroDePassageiros(int numeroDePassageiros) throws Exception{
		if(numeroDePassageiros >= 0) {
			this.numeroDePassageiros = numeroDePassageiros;
		}else {
			throw new Exception("O n�mero de passageiros transportados n�o pode ser negativo.");
		}
	}
	
	
	/**
	 * A n�mero total de passageiros transportados por um taxista.
	 * @return O n�mero de passageiros tranportados.
	 */
	public int getNumeroDePassageiros() {
		return numeroDePassageiros;
	}

	/**
	 * Calcula o devido valor do imposto que dever� ser pago pelo taxista.
	 */
	@Override
	public double calculaTributos() {
		return (numeroDePassageiros * 0.5);
	}
	
	/**
	 * Representa��o em String dos dados do taxista.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nN�mero total de passageiros transportados: "+numeroDePassageiros+"\n");
		return string.toString();
	}
}