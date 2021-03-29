package block_6.com;

import block_6.com.PhoneModel.Phone;

public class PhoneTest {
    public static void main(String[] args) {
        Phone ph1 = new Phone(111111, "Nokia", 150);
        Phone ph2 = new Phone(222222, "Samsung");
        Phone ph3 = new Phone();

        System.out.println(ph1);
        System.out.println(ph2);
        System.out.println(ph3);

        ph1.receiveCall("Vlad");
        ph2.receiveCall("Tanya");
        ph3.receiveCall("Sofia");

        System.out.println();

        ph1.receiveCall("Vlad", 123123);
        ph2.receiveCall("Tanya", 456456);
        ph3.receiveCall("Sofia",789789 );

        System.out.println();

        ph3.sendMessage(ph1.getNumber(), ph2.getNumber());
    }
}
