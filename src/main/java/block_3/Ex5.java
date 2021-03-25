package block_3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        //напиши программу которая будет заполнять такого рода матрицу до 10 уровня по новым темам
        int[][] pascal = new int[11][];
        for(int i = 1; i <= pascal.length; i++){
            pascal[i-1]  = new int[i];
        }
        for(int i = 0; i < pascal.length; i++){
            for(int j = 0; j < pascal[i].length; j++){
                if(j == 0 || j == pascal[i].length-1)
                    pascal[i][j] = 1;
                else if(j==1 || j==pascal[i].length-2)
                    pascal[i][j] = i;
                else if(j==2 || j==pascal[i].length-3)
                    pascal[i][j] = (i*(i-1))/2;
                else
                    pascal[i][j] = Fact(i)/(Fact(j) * Fact(i-j));
            }
        }
        int len = 1;
        for (int[] row:
             pascal) {
            System.out.printf("%s\n",Arrays.toString(row));
            len--;
        }

    }
    static int Fact(int n){
        if(n==0 || n== 1){
            return 1;
        }
        n = n * Fact(n-1);
        return n;
    }
}
