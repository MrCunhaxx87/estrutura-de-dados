public class Numbers {
    public static void main(String[] args) {
		int n = 10,sum = 0; // limite dos numeros
		
		System.out.print("Numeros de 1 a " + n + ": "); 
		for (int i=1; i<=n; i++){
			sum = sum + i;
			if(i==n)
			System.out.print(i);
			else
			System.out.print(i + ",");
		}
		System.out.println("\n"+"Soma = " + sum);
	}
}
