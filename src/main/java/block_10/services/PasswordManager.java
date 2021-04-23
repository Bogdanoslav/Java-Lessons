package block_10.services;

import block_10.interfaces.EncryptorI;

public class PasswordManager {
    private EncryptorI encryptor;

    public PasswordManager(EncryptorI encryptor) {
        this.encryptor = encryptor;
    }

    public void setEncryptor(EncryptorI encryptor) {
        this.encryptor = encryptor;
    }

    public String encrypt(String password){
        return encryptor.encrypt(password);
    }
}
