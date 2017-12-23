
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/


/**
 * Classe que define um m�dico.
 */
public class Medico extends Contribuinte{

	private int numeroDePacientesAtendidos;
	private double gastosEmCongressos;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do m�dico.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param temCasaPropria Ser� passado true se o m�dico tiver casa pr�pria, false se n�o tiver.
	 * @param temCarro Ser� passado true se o m�dico tiver carro, false se n�o tiver.
	 * @param valorDosBens Valor somado de todos os bens do m�dico.
	 * @param numeroDePacientesAtendidos N�mero de pacientes atendidos pelo m�dico em um ano.
	 * @param gastosEmCongressos Total de gastos que o m�dico teve em congressos.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada ao construtor seja inv�lida.
	 */
	public Medico(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, int numeroDePacientesAtendidos, double gastosEmCongressos) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(numeroDePacientesAtendidos, gastosEmCongressos);
	}

	/**
	 * Valida as informa��es do m�dico.
	 * @param numeroDePacientesAtendidos Ser� validado o valor passado referente ao total de pacientes atendidos pelo m�dico em um ano.
	 * @param gastosEmCongressos Ser� validado o valor passado referente ao total de gastos que o m�dico teve em congresssos.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada seja inv�lida.
	 */
	private void validaDados(int numeroDePacientesAtendidos, double gastosEmCongressos) throws Exception{
		if(numeroDePacientesAtendidos >= 0) {
			this.numeroDePacientesAtendidos = numeroDePacientesAtendidos;
		}else {
			throw new Exception("O n�mero de pacientes atendidos pelo m�dico n�o pode ser negativo.");
		}
		if(gastosEmCongressos >= 0) {
			this.gastosEmCongressos = gastosEmCongressos;
		}else {
			throw new Exception("O total de gastos em congressos do m�dico n�o pode ser negativo.");
		}
	}
	
	/**
	 * Retorna o n�mero total de pacientes atendidos pelo m�dico.
	 * @return O n�mero de pacientes que o m�dico atendeu.
	 */
	public int getNumeroDePacientesAtendidos() {
		return numeroDePacientesAtendidos;
	}

	/**
	 * Retorna o total de gastos que o m�dico teve em congressos.
	 * @return Os gastos em congressos.
	 */
	public double getGastosEmCongressos() {
		return gastosEmCongressos;
	}

	/**
	 * Calcula o devido valor do imposto que dever� ser pago pelo m�dico.
	 */
	@Override
	public double calculaTributos() {
		return numeroDePacientesAtendidos * 10;
	}

	/**
	 * Calcula os descontos que ser�o aplicados ao m�dico.
	 */
	@Override
	public double calculaDesconto() {
		return this.gastosEmCongressos;
	}
	
	/**
	 * Representa��o em String dos dados do m�dico.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nN�mero de pacientes atendidos: "+numeroDePacientesAtendidos);
		string.append(String.format("\nTotal de gastos em congressos: R$ %,.2f\n", gastosEmCongressos));
		return string.toString();
	}
}