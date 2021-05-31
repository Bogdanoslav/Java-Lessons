package block_14_Threads;

public class Matrix {
    int[][] matrix;
    int r;
    int c;

    public Matrix( int r, int c) {
        this.r = r;
        this.c = c;
        matrix = new int[r][c];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    void printMatrix(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
