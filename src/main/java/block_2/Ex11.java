package block_2;
import java.util.concurrent.ThreadLocalRandom;
public class Ex11 {
    public static void main(String[] args) {
        int rand = ThreadLocalRandom.current().nextInt();
        System.out.println("Рандомное число " + rand);
        if(rand%2==0){
            System.out.println("Четное");
        } else{
            System.out.println("Нечетное");
        }
    }
}
