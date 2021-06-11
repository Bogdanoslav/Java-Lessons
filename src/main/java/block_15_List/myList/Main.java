package block_15_List.myList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add(0,"A");
        myList.add(3,"B");
        myList.add(6,"C");
        System.out.println(myList.contains("C"));
        System.out.println(myList.indexOf("C"));

        System.out.println(myList.remove("C"));
        System.out.println(myList.remove(0));

        System.out.println(myList.contains("C"));
        System.out.println(myList.indexOf("C"));

        System.out.println(myList.get(2));
        System.out.println(myList.set(2, "NOT B"));
        System.out.println(myList.get(2));
        for (String s:
             myList) {
            System.out.print(s + " ");
        }
        myList.clear();
        System.out.println(myList.isEmpty());
        for (String s:
                myList) {
            System.out.print(s + " ");
        }

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
