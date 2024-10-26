import java.util.Scanner;

public class ReadNumbers {

    static void writeArray(int v[]){
        for(int i = 0; i<v.length; i++){
            System.out.println("v[" + i + "] = " + v[i]);
        }
    }

    static void amplitude(int v[]){

        int max=0;
        int min=v[0];

        for(int i=0; i<v.length; i++){
            if(v[i]>max)
                max = v[i];
            if(v[i]<min)
                min = v[i];
        }
        System.out.println("Amplitude = " + (max - min));

    }

    public static void main(String[] args){

       
        Scanner stdin = new Scanner(System.in);

        int v[] = new int[10];     // Criar um array de inteiros de tamanho 10;
        int n = stdin.nextInt();  // Leitura da primeira linha do txt -> Quantidade de inteiros no txt.
        for(int i = 0; i<n; i++)
            v[i] = stdin.nextInt();

        writeArray(v);
        amplitude(v);

        stdin.close();
    }
    
}
