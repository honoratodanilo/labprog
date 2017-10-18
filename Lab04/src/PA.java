
public class PA {

	public double calculaPa(int a1, int n, int c){
	    int i = 0;
	    int resultado = 0;
	    while(i < n){
	      resultado = a1;
	      System.out.println(resultado);
	      a1 = resultado + c;
	      i++;
	    }
	    return resultado;
	    
	  }
	
		public static int calculaPaN(int a1, int n, int c){
		    int i = 0;
		    int resultado = 0;
		    while(i < n){
		      resultado = a1;
		      a1 = resultado + c;
		      i++;
		    }
		    return resultado;
		
	}
		public static int calculaPaPrimeiro(int a1, int n, int c){
		    return a1;
		
	}
}
