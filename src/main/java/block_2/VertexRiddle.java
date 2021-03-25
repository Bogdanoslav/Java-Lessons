package block_2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class VertexRiddle {
    public static void main(String[] args){
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        Scanner scan = new Scanner(System.in);
        String answer;
        for(int i = 1; i <= 3; i++){
            answer = scan.nextLine();
            if(answer.equals("троллейбус")){
                System.out.println("Правильно!");
                break;
            } else if(answer.toLowerCase()=="сдаюсь"){
                break;
            } else{
                System.out.println("Подумай еще");
            }
        }

    }
}
