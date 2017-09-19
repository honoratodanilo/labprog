

import java.util.Scanner;


/*
 * Autor: Danilo Honorato
 * Descrição: Comparativo entre 3 números digitados, informando o número maior e menor.
 * 
 * */

public class MinMax2{
public static void main(String[] args) {
    
	int i;
	int estetica = 1;
	int LIMITE_NUMEROS = 3;
    int vetor[]= new int [+LIMITE_NUMEROS];

    
    Scanner leitor= new Scanner(System.in);
    int maior = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;
    
  //Verificando a quantidade de números que deve ser digitado
    for(i=0;i<= LIMITE_NUMEROS-1;i++){
        System.out.print("Digite o " + estetica +" valor : ");
        estetica++;
        vetor[i]=leitor.nextInt();
    }
  
    for(i = 0;i<= LIMITE_NUMEROS-1;i++){
           
            if(vetor[i]>maior){
                maior= vetor[i];
            }
            if(vetor[i]<menor){
               menor=vetor[i]; 
            }

        }
    System.out.println("O Menor valor digitado : "+menor);
    System.out.println("O Maior valor digitado : "+maior);   
	}
}