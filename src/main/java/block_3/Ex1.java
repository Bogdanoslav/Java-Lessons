package block_3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        //1) Написать программу, заводящую массив из 5 целых чисел, заполняющую
        //его числами, введенными с клавиатуры, и печатающую, сколько раз в этом
        //массиве встречается цифра 1.

        //2) Переписать программу из предыдущего задания так, чтобы считалась сумма введенных числе

        int[] nums = new int[5];
        Scanner scan = new Scanner(System.in);
        int count1 = 0;
        int sum = 0;

        System.out.printf("Введите %d целых чисел\n", nums.length);

        for(int i = 0; i < nums.length; i++){
            System.out.printf("Число #%d -> ", i+1);
            if((nums[i] = scan.nextInt())==1){
                count1++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }

        System.out.println(Arrays.toString(nums));
        System.out.printf("Количество единиц %d\n", count1);
        System.out.printf("Сумма элементов массива %d", sum);
    }
}
