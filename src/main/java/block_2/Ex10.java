package block_2;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите натуральное число для нахождения суммы заданного N: ");
        int n = scan.nextInt();
        System.out.println(findN5(n));
    }
    public static int findN5(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum+=i*5;
        }
        return sum;
    }
}
