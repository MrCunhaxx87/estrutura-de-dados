import java.util.Scanner;

public class Estatistica {

    static void media(int v[], int n){
        int sum = 0;

        for(int i=0; i<v.length; i++){
            sum += v[i];
        }
        System.out.printf("%.2f\n", (double)(sum)/n);
    } 
    
    static void amplitude(int v[]){
        
        int max=v[0];
        int min=v[0];
        for(int i=1; i<v.length;i++){
            if(max<v[i])
                max = v[i];
            if(min>v[i])
                min = v[i];
        }
        System.out.println(max-min);
    }


    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        int vec[] = new int[n];

        for(int i=0; i<n; i++) {
            vec[i] = stdin.nextInt();
        }
        media(vec, n);
        amplitude(vec);
        stdin.close();
    }
}
