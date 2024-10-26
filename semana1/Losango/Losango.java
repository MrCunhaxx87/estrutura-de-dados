

public class Losango{

    public static void main(String[] args){
	

	int n = 7;
	
	for(int i=1; i<=n; i+=2){

		// Pontos Esquerda Cima
	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(" ");
            }
	    // # de cima
	    for(int j=1; j<=i; j++){
		if(j!=i)
		    System.out.print("#");
		else
		    System.out.println("#");
	                     		    
	    }

	}

	 for(int i=n-2; i>=1; i-=2){

	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(" ");
            }
	    
	    for(int j=1; j<=i; j++){
		if(j!=i)
		    System.out.print("#");
		else
		    System.out.println("#");
	                     		    
	    }  

		}	
	}
}
