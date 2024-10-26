public class Palindromo{

    static boolean  isPalindromo(String a){

		String b = new StringBuilder(a).reverse().toString();
		
		return a.equals(b);
		
		}

		public static void main(String[] args){


		String a = "arara" ;
		String b = "hello";

		System.out.println(isPalindromo(a));
		System.out.println(isPalindromo(b));



    }

}
