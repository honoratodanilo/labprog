
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/


/**
 * Classe que define os rodovi�rios.
 */
public abstract class Rodoviario extends Contribuinte{

	private double quilometragemPercorrida;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do rodovi�rio.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param temCasaPropria Ser� passado true se o rodovi�rio tiver casa pr�pria, false se n�o tiver.
	 * @param temCarro Ser� passado true se o rodovi�rio tiver carro, false se n�o tiver.
	 * @param valorDosBens Valor somado de todos os bens do rodovi�rio.
	 * @param quilometragemPercorrida Total de quil�metros percorridos pelo rodovi�rio.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada ao construtor seja inv�lida.
	 */
	public Rodoviario(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		setQuilometragem(quilometragemPercorrida);
	}

	/**
	 * Valida a quilometragem percorrida pelo rodovi�rio.
	 * @param quilometragemPercorrida O valor (km) que ser� verificado.
	 * @throws Exception Ser� lan�ada caso o valor (km) passado seja inv�lido.
	 */
	private void setQuilometragem(double quilometragemPercorrida) throws Exception{
		if(quilometragemPercorrida >= 0) {
			this.quilometragemPercorrida = quilometragemPercorrida;
		}else {
			throw new Exception("Valor da quilometragem inv�lido.");
		}
	}
	
	/**
	 * Retorna a quil�metragem total percorrida por um rodovi�rio.
	 * @return A quilometragem percorrida por um rodovi�rio.
	 */
	public double getQuilometragemPercorrida() {
		return quilometragemPercorrida;
	}

	/**
	 * Calcula os descontos que ser�o aplicados aos rodovi�rios.
	 */
	@Override
	public double calculaDesconto() {
		return (quilometragemPercorrida * 0.01);
	}
	
	/**
	 * Representa��o em String dos dados do rodovi�rio.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nQuilometragem total percorrida: %,.1f km", quilometragemPercorrida));
		return string.toString();
	}
}