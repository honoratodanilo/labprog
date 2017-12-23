
/*
 * Aluno 01: Jo�o Victor
 * Aluno 02: Danilo Honorato
*/

/**
 * Classe que define um professor.
 */
public class Professor extends Contribuinte {

	private final double SALARIO_MINIMO = 925.00;
	private double salario;
	private double gastosComMateriais;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do professor.
	 * @param numeroDoContribuinte N�mero de cadastro do contribuinte.
	 * @param temCasaPropria Ser� passado true se o professor tiver casa pr�pria, false se n�o tiver.
	 * @param temCarro Ser� passado true se o professor tiver carro, false se n�o tiver.
	 * @param valorDosBens Valor somado de todos os bens do professor.
	 * @param salario Valor do sal�rio recebido pelo professor.
	 * @param gastosComMateriais Total de gastos que o professor teve com seus materiais.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada ao construtor seja inv�lida.
	 */
	public Professor(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double salario, double gastosComMateriais) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(salario, gastosComMateriais);
	}

	/**
	 * Valida as informa��es do professor.
	 * @param salario Ser� validado o valor do sal�rio do professor que ser� passado como argumento.
	 * @param gastosComMateriais Ser� validado o valor total de gastos com materiais que o professor teve e que ser� passado como argumento.
	 * @throws Exception Ser� lan�ada caso alguma informa��o passada seja inv�lida.
	 */
	private void validaDados(double salario, double gastosComMateriais) throws Exception{
		if(salario > 0) {
			this.salario = salario;
		}else {
			throw new Exception("Valor do sal�rio do professor inv�lido.");
		}
		if(gastosComMateriais >= 0) {
			this.gastosComMateriais = gastosComMateriais;
		}else {
			throw new Exception("Os gastos com materiais n�o pode ser um valor negativo.");
		}		
	}
	
	/**
	 * Retorna o sal�rio do professor.
	 * @return O sal�rio do professor.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Retorna o valor total que o professor teve com materiais.
	 * @return O valor gasto em materiais.
	 */
	public double getGastosComMateriais() {
		return gastosComMateriais;
	}

	/**
	 * Calcula o devido valor do imposto que dever� ser pago pelo professor.
	 */
	@Override
	public double calculaTributos() {
		double imposto;
		if(salario <= SALARIO_MINIMO) {
			imposto = (salario * 0.05);
		}else if(salario <= 5*SALARIO_MINIMO) {
			imposto = (salario * 0.1);
		}else {
			imposto = (salario * 0.2);
		}
		return imposto;
	}

	/**
	 * Calcula os descontos que ser�o aplicados ao professor.
	 */
	@Override
	public double calculaDesconto() {
		return (gastosComMateriais * 0.5);
	}
	
	/**
	 * Representa��o em String dos dados do professor.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nSal�rio: R$ %,.2f", salario));
		string.append(String.format("\nGastos com materiais: R$ %,.2f\n", gastosComMateriais));
		return string.toString();
	}
}