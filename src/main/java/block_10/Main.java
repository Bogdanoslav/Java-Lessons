package block_10;

import block_10.abstractClasses.Account;
import block_10.interfaces.EncryptorI;
import block_10.models.OschadBankAccount;
import block_10.models.PrivatBankAccount;
import block_10.models.User;
import block_10.services.EncryptorX;
import block_10.services.EncryptorY;
import block_10.services.PasswordManager;
import block_10.services.AccountReport;

public class Main {
    public static void main(String[] args) {
        EncryptorI encryptorX = new EncryptorX();
        EncryptorI encryptorY = new EncryptorY();

        String passwordPrivat = "privat";
        String passwordOschad = "oschad";

        PasswordManager pm = new PasswordManager(encryptorX);
        passwordPrivat = pm.encrypt(passwordPrivat);
        pm.setEncryptor(encryptorY);
        passwordOschad = pm.encrypt(passwordOschad);

        Account pba = new PrivatBankAccount(123,passwordPrivat, 1189);
        Account oba = new OschadBankAccount(321,passwordOschad, 20000);

        AccountReport par = new AccountReport();
        User user = new User("Vasya");

        Account[] accounts = {pba, oba};
        user.setAccounts(accounts);
        par.printAll(user.getAccounts());
    }
}
