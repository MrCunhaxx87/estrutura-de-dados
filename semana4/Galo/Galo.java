import java.util.Scanner;

class Board{

    char[][] data;
    int length;

    Board(int dim){
        data = new char[dim][dim];
        length = dim;
    }

    public void read(Scanner stdin){
        for(int i=0; i<this.length;i++){
            String line = stdin.nextLine();
            for(int j=0; j<this.length; j++){
                data[i][j] = line.charAt(j);
            }
        }
    }



    public char checkLine(){
        
        for(int i=0; i<this.length; i++){
            int countO = 0;
            int countX = 0;

            for(int j=0; j<this.length; j++){
                if(this.data[i][j]=='X')
                    countX++;
                else if(this.data[i][j]== 'O')
                    countO++;
            }
            if(countX == this.length)
                return 'X';
            else if(countO == this.length)
                return 'O';

        }
        return ' ';
    }

    public char checkColumns(){
        for(int j=0; j<this.length; j++){
            int countX = 0;
            int countO = 0;

            for(int i=0; i<this.length; i++){
                if(this.data[i][j] == 'X')
                   countX++;
                else if(this.data[i][j] == 'O')
                    countO++;
            }
            if(countX == length)
                return 'X';
            else if(countO == length)
                return 'O';
            
        }
        return ' ';
    }

    public char checkDiagonally(){
        
        int countX = 0;
        int countO = 0;

        // Check diagonal Esquerda
        for (int i = 0; i < this.length; i++) {
            if (this.data[i][i] == 'X')
                countX++;
            else if (this.data[i][i] == 'O')
                countO++;
        }
        if (countX == this.length)
            return 'X';
        else if (countO == this.length)
            return 'O';

        countX = 0;
        countO = 0;

        // Check diagonal Direita
        for (int i = 0; i < this.length; i++) {
            if (this.data[i][this.length - i - 1] == 'X')
                countX++;
            else if (this.data[i][this.length - i - 1] == 'O')
                countO++;
        }
        if (countX == this.length)
            return 'X';
        else if (countO == this.length)
            return 'O';

        return ' ';
    }

    public String checkGame(){

        char lineResult = this.checkLine();
        char columnResult = this.checkColumns();
        char diagonalResult = this.checkDiagonally();

        if (lineResult == 'X' || columnResult == 'X' || diagonalResult == 'X') {
            return "Ganhou o X";
        } else if (lineResult == 'O' || columnResult == 'O' || diagonalResult == 'O') {
            return "Ganhou o O";
        }

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                if (this.data[i][j] == '.') {
                    return "Jogo incompleto";
                }
            }
        }

        return "Empate";
    }
    

}

public class Galo {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        Board board = new Board(stdin.nextInt());

        stdin.nextLine(); // Sem isso causa erro ao consumir a proxima linha.

        board.read(stdin);

        String result = board.checkGame();

        System.out.println(result);

        stdin.close();
        
    }
}
