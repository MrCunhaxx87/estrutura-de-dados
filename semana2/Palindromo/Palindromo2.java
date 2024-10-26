import java.util.Scanner;

public class Palindromo2{

    static boolean isPalindromo(String a){

		// replaceAll("[^a-zA-Z]","") -> Substitui qualquer caracter que não seja letra por string "", no caso vazia
		// [^a-zA-Z] -> o ^ nega a expressão a-zA-Z, ou seja, apenas especiais. Sem o ^ trocaria todas as letras e não os especiais.
		
		a = a.replaceAll("[^a-zA-Z]", "").toLowerCase();

		int size = a.length();
		for(int i = 0 ;i < size/2; i++ ){

			if(a.charAt(i) != a.charAt(size-1-i)  )
			return false;
		}
		return true;
    }

    public static void main(String[] args){

		
		Scanner stdin = new Scanner(System.in);
		
		int n = stdin.nextInt();
		System.out.println(n);

		stdin.nextLine(); // Posto para que nao seja testado a quebra da linha.

		while (stdin.hasNextLine()) {
			String line = stdin.nextLine();
			if(isPalindromo(line) == true)
				System.out.println("sim");
			else
				System.out.println("nao");
			
		}

		stdin.close();
    }
}
