package block_5;
import com.LazyArray;
public class Main {
    public static void main(String[] args) {
        String[] namesold = {"Anatoly", "Pavel", "Larisa", "Eugene"};
        String[] namesnew = {"Anatoly", "Larisa", "Mike", "Kate"};

        String[] namesNoDup = LazyArray.RemoveDupString(namesold, namesnew);
        for (String name:
            namesNoDup ) {
            System.out.println(name);
        }
    }
}
