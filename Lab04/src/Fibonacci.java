/*Aluno 1: Danilo Honorato*/
/*Aluno 2: João Victor*/
public class Fibonacci {
		 
	   public static int fibo(int n) {
			for(int a=0, b=1, i=0; i<n; b+=a, a=b-a, i++) {
				System.out.print(a+" ");
			}  
			return 0;
	    }
	    
	 
	    static int fiboN(int n) {
	    	int a=0, b=1;
			for(int i=0; i<n;) {
				b+=a;
				a=b-a;
				i++;
			}
			return b-a;
				
	    }
	    	
	}