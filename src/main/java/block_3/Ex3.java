package block_3;

public class Ex3 {
    public static void main(String[] args) {
        //Дан массив натуральных чисел. Найти сумму элементов, кратных 5

        int[] nums = {1, 2, 5, 7, 15, 45, 6, 17, 35};
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%5==0){
                sum+=nums[i];
            }
        }
        System.out.printf("Сумма элементов кратных трем %d", sum);
    }
}
