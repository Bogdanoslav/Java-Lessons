package block_14_Threads;

import lombok.SneakyThrows;

public class MatrixFiller implements Runnable{
    Matrix matrix;
    int r;

    public MatrixFiller(Matrix matrix, int r) {
        this.matrix = matrix;
        this.r = r;
    }

    @SneakyThrows
    @Override
    public void run() {
        for(int i = 0; i < matrix.c; i++){
            System.out.println(Thread.currentThread().getName());
            matrix.getMatrix()[r][i] = (int)Thread.currentThread().getId();
        }
    }
}
