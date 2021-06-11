package block_15_List.model;

import block_15_List.model.User;
import block_15_List.model.UserMoneyComparator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new LinkedList<>();
        userList.add(new User("Vlad",45, 800));
        userList.add(new User("Nastya",58, 600));
        userList.add(new User("Oleg",17, 10000));
        userList.add(new User("Vitya",8, 13));
        userList.add(new User("Stas",100, 900));
        Collections.sort(userList);
        System.out.println(userList);
        Comparator<User> moneyComp = new UserMoneyComparator();
        Collections.sort(userList, moneyComp.reversed());
        System.out.println(userList);

    }
}
