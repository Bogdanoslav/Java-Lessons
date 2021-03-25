package block_2;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int userNum = scan.nextInt();
        int sum = 0;
        while(userNum!=0){
            sum+=userNum%10;
            userNum/=10;
        }
        System.out.println("Сумма цифр введенного числа = " + sum);
    }
}
