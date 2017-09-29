/*
 * @autores:Danilo Honorato
 * 			João Victor
 * 			Jeffiti Mucio
 * 
 */


import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);

    
    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();
        
        while( Jogar() );
    }
    
    public void iniciarJogadores(){
        System.out.println("------------ CRIANDO JOGADOR 1 ------------");
        if(escolherJogador() == 1)
            this.jogador1 = new Humano(1);
        
        System.out.println("----------------------");
        System.out.println("------------ CRIANDO JOGADOR 2 ------------");
        
        if(escolherJogador() == 1)
            this.jogador2 = new Humano(2);
        //Chamando o tabuleiro vazio antes de iniciar a jogada
        Tabuleiro chamar = new Tabuleiro();
        System.out.println("");
        System.out.println("Tabuleiro vazio iniciado. BOM JOGO!!");
        chamar.exibeTabuleiro();
    }
    

	public int escolherJogador(){
    int opcao=1;        
    return opcao;
}
    
    public boolean Jogar(){
        if(ganhou() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+rodada);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
            
            
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                Jogo voltando = new Jogo();
                return false;
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 ){
                System.out.println("Jogador 1 ganhou!");
                Jogo voltando = new Jogo();
            }else{
                System.out.println("Jogador 2 ganhou!");
                Jogo voltando = new Jogo();
            }
        }
		return false;
            
    }
    
    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}
