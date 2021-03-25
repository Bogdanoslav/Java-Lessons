package block_1;

public class Calculator {
    public static void main(String args[]) {
        Calculator calc = new Calculator();
        int a = 1;
        int b = 4;
        System.out.printf("%d + %d = %d\n", a, b, calc.addNums(1, 4));
        System.out.printf("%d - %d = %d\n", a, b, calc.subNums(1, 4));
        System.out.printf("%d * %d = %d\n", a, b, calc.multNums(1, 4));
        System.out.printf("%d / %d = %d\n", a, b, calc.divNums(1, 4));

    }

    public int addNums(int a, int b) {
        return a + b;
    }

    public int subNums(int a, int b){
        return a - b;
    }
    public int multNums(int a, int b){
        return a * b;
    }
    public int divNums(int a, int b){
        return a / b;
    }
}
