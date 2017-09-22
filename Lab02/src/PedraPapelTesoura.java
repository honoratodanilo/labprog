import java.util.Random;
import java.util.Scanner;


/*
 * Autor: Danilo Honorato
 * Descrição: 
 * 
 * */


public class PedraPapelTesoura {

	public static void main(String[] args) {
        
		int instrucoesIniciais = instrucoes();
		
		int PARAR = -1;
        //Manipulando escolhas
		switch(instrucoesIniciais) {
		case 1:
			int player1 = 0;
			int player2 = 0;
			while(player1 != PARAR || player2 != PARAR) {
				Scanner p1= new Scanner(System.in);
				System.out.println("Pedra [1], Papel [2], Tesoura [3]?");
				player1 = p1.nextInt();
				if(player1 == PARAR){
					System.out.println("Você digitou -1 em uma das opções e saiu do JOGO!");
					break;
				}
				Scanner p2= new Scanner(System.in);
				System.out.println("Pedra [1], Papel [2], Tesoura [3]?");
				player2 = p2.nextInt();
				if(player2 == PARAR){
					System.out.println("Você digitou -1 em uma das opções e saiu do JOGO!");
					break;
				}
			if(player1 >=1 && player1 <=3 && player2 >=1 && player2 <=3) {
			int calculoAmigo = calculoContra(player1,player2);
			}else {
				System.out.println("Você digitou um valor diferente de 1,2 ou 3 em algumas das jogadas. Leia as instruções e jogue novamente.");
				int intrucoesInicias2 = instrucoes();
			}
			}
			
			break;
		case 2:
			Random r = new Random();
			int computador = 1 + r.nextInt(3);
			player1 = 0;
			while( player1 != PARAR) {
				Scanner p1= new Scanner(System.in);
				System.out.println("Pedra [1], Papel [2], Tesoura [3]?");
				player1 = p1.nextInt();	
				if(player1 == PARAR){
					System.out.println("Você digitou -1 em uma das opções e saiu do JOGO!");
					break;
				}
				if(player1 >=1 && player1 <=3) {
					int calculoAmigo = calculoContra(player1,computador);
					}else {
						System.out.println("Você digitou um valor diferente de 1,2 ou 3 em algumas das jogadas. Leia as instruções e jogue novamente.");
						int intrucoesInicias2 = instrucoes();
					}
			}

			break;
		}
		
	}
	
	
	
	
	
	
	//Metodos
	
	//Instruções inicias
	 private static int instrucoes(){
		int escolha = 0;
		Scanner leitor= new Scanner(System.in);
		System.out.println("* * * * * INSTRUÇÕES * * * * *");
		System.out.println("[X] Selecione 1 para jogar contra seu AMIGO");
		System.out.println("[X] Selecione 2 para jogar contra o COMPUTADOR");
		System.out.println("[X] Digite a qualquer momento -1 para sair do jogo");
	       escolha = leitor.nextInt();
	    if(escolha != 1 && escolha != 2){
	    System.out.println("Escolha uma opção válida!");
	       return instrucoes();
	    }
	    return escolha;
			}	
	 
	//Calculo
	private static int calculoContra(int i,int j){
		int n = 3;
		int res = (n+i-j)%n;
		
		if(res >0 && res <= n/2){
			System.out.println(""+i+"-"+j);
			System.out.println("Jogador 1 ganhou!");
			return 0;
		}
		if(res >n/2){
			System.out.println(""+i+"-"+j);
			System.out.println("Jogador 2 ganhou!");
			return 0;
		}
		if(res == 0){
			System.out.println(""+i+"-"+j);
			System.out.println("Empate");
			return 0;
		}
		return 0;
	}


}



