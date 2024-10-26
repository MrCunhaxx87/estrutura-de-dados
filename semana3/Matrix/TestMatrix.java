import java.util.Scanner;

class Matrix{

    int data[][];
    int rows;
    int cols;

    Matrix(int r, int c){

        data = new int[r][c];
        rows = r;
        cols = c;
    }

    public void read(Scanner in){
        for(int i =0; i<rows;i++)
            for(int j=0; j<cols; j++)
                data[i][j] = in.nextInt();
    }

    public String toString(){
        String ans = "";
        for(int i = 0; i<rows; i++){
            for(int j=0; j<cols; j++)
                ans += data[i][j] + " ";
            ans += "\n";
            }
        return ans;
    }

    public static Matrix identity(int n){

        Matrix m = new Matrix(n,n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(i == j)
                    m.data[i][j] = 1;
                else
                    m.data[i][j] = 0;
            }
        }
        return m;
    }

    public Matrix transpose(){

        Matrix transposta = new Matrix(cols,rows);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++)
                transposta.data[j][i] = this.data[i][j];
        }

        return transposta;
    }

    public Matrix sum(Matrix m){

        Matrix result = new Matrix(this.rows,this.cols);

        if(this.rows == m.rows && this.cols == m.cols){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j<cols; j++){
                    result.data[i][j] = this.data[i][j] + m.data[i][j];            
                }
            }
        }
        return result;
    }

    public Matrix multiply(Matrix m){

        Matrix result = new Matrix(this.rows,m.cols);

        if(this.cols == m.rows){
            for(int i=0; i<this.rows; i++){
                for(int j=0; j<m.cols;j++){

                    result.data[i][j]=0;
                    for(int k=0; k<this.cols;k++)
                        result.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        return result;
    }
}

public class TestMatrix {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
            
        Matrix m1 = Matrix.identity(5);
        System.out.println(m1);

        Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m2.read(stdin);
        System.out.println(m2);
        Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m3.read(stdin);
        System.out.println(m3);
        Matrix m4 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m4.read(stdin);
        System.out.println(m4);

        Matrix m5 = m1.transpose();
        System.out.println(m5);
        Matrix m6 = m2.transpose();
        System.out.println(m6);

        Matrix m7 = m2.sum(m3);
        System.out.println(m7);
        Matrix m8 = m2.multiply(m4);
        System.out.println(m8);

        stdin.close();
    }
    
}
