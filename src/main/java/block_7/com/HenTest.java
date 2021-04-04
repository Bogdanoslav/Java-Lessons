package block_7.com;

import block_7.com.models.*;

import java.util.Scanner;

public class HenTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите расположение фермы (UKRAINE, MOLDOVA, BELARUSSIA, RUSSIA): ");
        String userAnsw = scanner.nextLine();
        Farm farm = null;
        try {
            Farm.FarmType ft = Farm.FarmType.valueOf(userAnsw.toUpperCase());
            switch (ft){
                case MOLDOVA:
                    farm = new MoldovanFarm();
                    break;
                case UKRAINE:
                    farm = new UkrainianFarm();
                    break;
                case BELARUSSIA:
                    farm = new BelarussianFarm();
                    break;
                case RUSSIAN:
                    farm = new RussianFarm();
                    break;
            }
        } catch (IllegalArgumentException e){
            System.out.println("Такого расположения фермы нет");
        }
        System.out.println(farm.collectEggs());
    }
}
