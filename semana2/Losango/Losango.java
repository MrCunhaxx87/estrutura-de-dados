import java.util.Scanner;

public class Losango{
	
	static void losSuperior(int n){
	
	for(int i=1; i<=n; i+=2){

		// Pontos Esquerda Cima
	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(".");
            }
	    // # de cima
	    for(int j=1; j<=i; j++){
		    System.out.print("#");
	                     		    
	    }
	    // Pontos à direita
		for (int j = 1; j <= (n - i) / 2; j++) {
			System.out.print(".");
		}
		System.out.println(); // Nova linha
	}

}

	static void losInferior(int n){

	// Parte inferior do Losango
	for(int i=n-2; i>=1; i-=2){

	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(".");
            }
	    
	    for(int j=1; j<=i; j++){
			System.out.print("#");           		    
	    	}

		for(int j=1; j<=(n-i)/2 ; j++)
			System.out.print(".");	
		
		System.out.println();
	}


}
    
	public static void main(String[] args){
	
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		
		losSuperior(n);
		losInferior(n);

	/*
	// Parte superior do Losango
	for(int i=1; i<=n; i+=2){

		// Pontos Esquerda Cima
	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(".");
            }
	    // # de cima
	    for(int j=1; j<=i; j++){
		    System.out.print("#");
	                     		    
	    }
	    // Pontos à direita
		for (int j = 1; j <= (n - i) / 2; j++) {
			System.out.print(".");
		}
		System.out.println(); // Nova linha
	}

	// Parte inferior do Losango
	for(int i=n-2; i>=1; i-=2){

	    for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(".");
            }
	    
	    for(int j=1; j<=i; j++){
			System.out.print("#");           		    
	    }
		for(int j=1; j<=(n-i)/2 ; j++)
			System.out.print(".");	
		System.out.println();
	}
	*/

	stdin.close();
    }
}
