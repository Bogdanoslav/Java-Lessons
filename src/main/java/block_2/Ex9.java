package block_2;

public class Ex9 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int fib;
        System.out.print(1 + " ");
        for(int i = 1; i <= 11; i++){
            fib = a + b;
            a = b;
            b = fib;
            System.out.print(fib + " ");
        }
    }
}
