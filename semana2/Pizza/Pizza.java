import java.util.Scanner;

public class Pizza {
    
    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);
        int qtd_ingRuins = stdin.nextInt();
        int ing_ruins[] = new int[qtd_ingRuins];
        
        for(int i = 0; i < qtd_ingRuins; i++){
            ing_ruins[i] = stdin.nextInt();
        }

        int qtd_pizzas = stdin.nextInt();
        int ing_pizza[][] = new int[qtd_pizzas][];

        for(int i = 0; i< qtd_pizzas; i++){

            int qtd_ingPizza = stdin.nextInt();
            ing_pizza[i] = new int[qtd_ingPizza];

            for(int j = 0; j < qtd_ingPizza; j++){
                ing_pizza[i][j] = stdin.nextInt();
            }
        }

        int count = 0;
        
        for(int i = 0; i < qtd_pizzas; i++){
            boolean pizzaOk = true;

            for(int j = 0; j < ing_pizza[i].length; j++){
                for(int k = 0; k < qtd_ingRuins; k++){
                    if(ing_pizza[i][j] == ing_ruins[k]){
                        pizzaOk = false;
                        break;
                    }
                }
                if(!pizzaOk)
                    break;
            }
            if(pizzaOk)
                count++;
            
        }

        System.out.println(count);

        stdin.close();
    }
}
