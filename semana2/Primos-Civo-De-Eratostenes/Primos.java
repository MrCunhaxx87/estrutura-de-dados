import java.util.Scanner;

public class Primos {

    static boolean isPrime(int n){

        if(n <= 1)
            return false;
        for(int d=2; d*d<=n; d++){
            if(n%d==0)
                return false;
        }

        return true;
    }
    static boolean[] EratostenesSieve(){
        int size = 10000000;
        boolean Sieve[] = new boolean[size];

        for(int i=2; i < size; i++){
            Sieve[i] = true;
        }

        for(int p=2; p*p < size; p++){
            if(Sieve[p]){
                for(int multiple = p*p; multiple < size; multiple += p)
                    Sieve[multiple] = false;
            }
        }
        return Sieve;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        int count = 0;
        boolean[] Sieve = EratostenesSieve();
        
        if(b>=10000000)
            b = 9999999;
            
        for(int i=a; i<=b; i++){
            if(Sieve[i]==true)
                count++;
        }
        
        System.out.println(count);
        
        stdin.close();
    }
    
}
