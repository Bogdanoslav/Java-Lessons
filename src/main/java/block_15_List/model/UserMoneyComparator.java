package block_15_List.model;

import java.util.Comparator;

public class UserMoneyComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getMoney()-o2.getMoney();
    }
}
