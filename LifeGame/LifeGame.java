import java.util.Scanner;

class Game{

    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols;j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
	// ... por completar
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int x, int y) {
	    int count = 0;
        
        // Caso a posição m[x][y] seja viva, o contador inicia -1 para evitar contar como vizinho.
        if (m[x][y] == ALIVE)
            count = -1;
        else
            count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i<this.m.length && j<this.m[0].length) {
                    if (this.m[i][j] == ALIVE) {
                        count++;
                    }
                }
            }
        }
    
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {

        char[][] nextState = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAlive(i, j);
    
                if (this.m[i][j] == ALIVE) {
                    // Célula viva morre se tiver menos de 2 ou mais de 3 vizinhos vivos
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        nextState[i][j] = DEAD;
                    } else {
                        nextState[i][j] = ALIVE;  // Caso contrário, continua viva
                    }
                } else {
                    // Célula morta renasce se tiver exatamente 3 vizinhos vivos
                    if (aliveNeighbors == 3) {
                        nextState[i][j] = ALIVE;
                    } else {
                        nextState[i][j] = DEAD;  // Caso contrário, continua morta
                    }
                }
            }
        }
    
        // Atualiza a matriz original para o próximo estado
        this.m = nextState;
    }


}


public class LifeGame {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n    = in.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);
        
        //... por completar
        for(int i=0;i<n;i++){
            g.iterate();
        }
        g.write();

        in.close();
        
    }
    
}
