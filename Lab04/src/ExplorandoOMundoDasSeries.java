import java.util.Scanner;

public class ExplorandoOMundoDasSeries {
	
	public static void main(String[] args) {
		
		int instrucoesIniciais = instrucoes();
	    switch(instrucoesIniciais) {
	    case 1:
	    	PA calculop;
	    	Scanner a1 = new Scanner(System.in);
			System.out.println("Informe o primeiro termo:");
			int termo1 = a1.nextInt();
			Scanner n = new Scanner(System.in);
			System.out.println("Informe o número de termos:");
			int qtdn = n.nextInt();
			Scanner r = new Scanner(System.in);
			System.out.println("Informe a razão da PA:");
			int razao = r.nextInt();
			calculop = new PA();
			calculop.calculaPa(termo1, qtdn, razao);
			instrucoesIniciais = instrucoes();
			break;
	    case 2:
	    	Fibonacci calculof;
	    	Scanner qtd = new Scanner(System.in);
			System.out.println("Informe a quantidade de números a exibir:");
			int quantidade = qtd.nextInt();
			calculof = new Fibonacci();
			calculof.fibo(quantidade);
			System.out.println(" ");
			instrucoesIniciais = instrucoes();
			break;
			
	    case 3:
	    	PA calculopn;
	    	Scanner a11 = new Scanner(System.in);
			System.out.println("Informe o primeiro termo:");
			int termo11 = a11.nextInt();
			Scanner n1 = new Scanner(System.in);
			System.out.println("Informe o número de termos:");
			int qtdn1 = n1.nextInt();
			Scanner r1 = new Scanner(System.in);
			System.out.println("Informe a razão da PA:");
			int razao1 = r1.nextInt();
			System.out.println("O " +qtdn1+ "º termo da sua PA é:"+PA.calculaPaN(termo11, qtdn1, razao1));
	    	instrucoesIniciais = instrucoes();
	    	break;
	    	
	    case 4:
	    	Fibonacci calculofn;
	    	Scanner qtd1 = new Scanner(System.in);
			System.out.println("Informe a quantidade de números a exibir:");
			int quantidade1 = qtd1.nextInt();
			calculofn = new Fibonacci();
			System.out.println("O " +quantidade1+ "º termo da sua série de Fibonacci é:"+Fibonacci.fiboN(quantidade1));
			System.out.println(" ");
			instrucoesIniciais = instrucoes();
			break;
	    case 5:
	    	System.out.println("Tentamos");
			break;
	    	
	    case 6:
	    	System.out.println("Você saiu!");
        }
	}

	
	public static int instrucoes() {
		int escolha = 0;
		Scanner leitor= new Scanner(System.in);
		System.out.println("* * * * * INSTRUÇÕES * * * * *");
		System.out.println("1. Para criar uma Progressão Aritmética");
		System.out.println("2. Para criar uma série de Fibonacci");
		System.out.println("3. Para ver o termo n da sua PA");
		System.out.println("4. Para ver o termo n da serie de Fibonacci");
		System.out.println("5. Para mostrar os n primeiros termos da sua PA e da serie de Fibonacci");
		System.out.println("6. Para sair");
	    escolha = leitor.nextInt();
	    return escolha;
	}
	}

