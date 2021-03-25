package block_3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        //4) Дан массив целых положительных чисел. Найти произведение
        //только тех чисел, которые больше заданного числа М. Если таких нет, то выдать
        //сообщение об этом.
        Scanner scan = new Scanner(System.in);
        int m;
        int sum = 0;
        int[] nums = {1, 2, 5, 7, 15, 45, 6, 17, 35};

        System.out.print("Введите натуральное число M: ");
        m = scan.nextInt();

        for(int i = 0; i < nums.length; i++){
            if(nums[i]>m){
                sum+=nums[i];
            }
        }
        if(sum != 0)
            System.out.printf("Сумма элементов больше %d = %d", m, sum);
        else
            System.out.println("Чисел больше M нет");
    }
}
