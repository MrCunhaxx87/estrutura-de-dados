public class Primes {
    // Verifica se o número n é primo (apenas divisível por 1 e por si próprio)
    // [função ainda por completar]
    static boolean isPrime(int n) {
		if(n<=1)
			return false;
		for(int d=2;d*d<=n;d++){
			if(n%d==0)
			return false;
		}
		return true;
    }
    
    public static void main(String[] args) {
		
		
		int n=1000000; // Limite dos números
		
		for (int i=2; i<=n; i++)
			if (isPrime(i))
			System.out.println(i);
	

			   
    }
}
