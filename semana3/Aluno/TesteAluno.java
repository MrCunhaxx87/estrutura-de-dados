import java.util.Scanner;

class Aluno{

    String nome;
    int numero;

    public static int contador = 0; 
    /*  A variavel estatica implica que ela pode ser chamada a qualquer momento
        independente se a classe tem objetos ou nao. */

    
    // Construtor da classe Aluno - forma padrão
    Aluno(String n, int mec){
        nome = n;
        numero = mec;
        contador++;
    }

    int ano() {
        return numero / 100000;
     }

    public String toString(){
        return "(" + nome + ", " + numero + ")";
    }
    


}


public class TesteAluno {
    
    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        String nom = stdin.nextLine();
        int num = stdin.nextInt();

        System.out.println("\ncontador = " + Aluno.contador);

        Aluno a = new Aluno(nom,num);
        Aluno b = new Aluno("modificado", -1);
        Aluno c = b; // Isso funciona como um apontador ao objeto pertencente a classe Aluno

        //Aluno d = new Aluno(); // Vai dar erro por faltar os argumentos necessários;
        Aluno e = new Aluno("Manuel", 201506234);
        //System.out.println("d = " + d); // Da erro por d não existir por ser erro de falta de Argumento
        System.out.println("e = " + e);

        System.out.println("**********************************************************");

        System.out.println("al.nome = " + a.nome);
        System.out.println("al.numero = " + a.numero);
        System.out.println("a = " + a); // Vai me retornar as informaçoes da classe Aluno em a.
        // System.out.println(a.getClass().getName()); para saber a classe da variavel
        
        System.out.println("**********************************************************");

        System.out.println("b = " + b);
        System.out.println("c = " + c);
        
        System.out.println("**********************************************************");

        Aluno g = new Aluno("Ana", 201408762);
        Aluno h = new Aluno("Bruno", 201508145);
        System.out.println(g.ano() + " " + h.ano());

        System.out.println("**********************************************************");

        int n = 3;
        Aluno[] v = new Aluno[n];
        for (int i=0; i<n; i++){
            v[i] = new Aluno("modificar",-1);
            System.out.println("v[" + i + "] = " + v[i]);
            
        }
        v[0].nome = "Pedro";
        System.out.println(v[0]);

        System.out.println("**********************************************************");

        System.out.println("contador = " + Aluno.contador);
        
        stdin.close();

    }
    
}
