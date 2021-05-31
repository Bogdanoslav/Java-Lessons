package block_14_Threads;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int row = 10, col = 10;
        Matrix matrix = new Matrix(row, col);

        for (int i = 0; i < row; i++) {
            MatrixFiller matrixFiller = new MatrixFiller(matrix, i);
            Thread thread = new Thread(matrixFiller);
            thread.start();
            if(i==row-1)
                thread.join();
        }
        matrix.printMatrix();
//--------------------------------------------------------------------
        GregorianCalendar gc = new GregorianCalendar();
        Runnable year = () -> {
            System.out.println(gc.get(Calendar.YEAR) + " Thread id: " + Thread.currentThread().getId());
        };
        Runnable month = () -> {
            System.out.println(gc.get(Calendar.MONTH) + " Thread id: " + Thread.currentThread().getId());
        };
        Runnable day = () -> {
            System.out.println(gc.get(Calendar.DAY_OF_MONTH) + " Thread id: " + Thread.currentThread().getId());
        };
        new Thread(year).start();
        new Thread(month).start();
        new Thread(day).start();
    }
}
