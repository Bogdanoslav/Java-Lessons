package block_10.services;

import block_10.abstractClasses.Account;

public class AccountReport {

    public static void print(Account account){
        System.out.print("\niban: " + account.getIban() +
                        "\npassword: " + account.getPassword() +
                        "\nsum: " + account.getSum()+
                        "\nmonthly deposit receipts: " + account.calcMonthlyDeposit());
    }
    public static void printAll(Account[] accounts){
        for (Account a:
             accounts) {
            print(a);
        }
    }
}
