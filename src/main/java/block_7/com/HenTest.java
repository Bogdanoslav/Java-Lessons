package block_7.com;

import block_7.com.enums.HenType;
import block_7.com.models.Hen;
import block_7.com.services.Fabric;

import java.util.Scanner;

public class HenTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите расположение фермы (UKRAINE, MOLDOVA, BELARUSSIA, RUSSIA): ");
        String userAnsw = scanner.nextLine();
        Fabric fabric = new Fabric();
        try {
            HenType ft = HenType.valueOf(userAnsw.toUpperCase());
            Hen hen = fabric.getHen(ft);
            System.out.println(hen.getCountOfEggsPerMonth());
        } catch (IllegalArgumentException e){
            System.out.println(userAnsw + " - Такого расположения фермы нет");
        }
    }
}
