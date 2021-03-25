package block_2;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите целое положительное число: ");
        int userNum = scan.nextInt();

        int sum = 0;
        for(int i = 1; i < userNum; i++){
            sum+=i;
        }

        System.out.print("Сумма чисел до введеного вами числа = " + sum);
    }
}
