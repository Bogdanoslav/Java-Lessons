package block_10.abstractClasses;

public abstract class Account {

    protected int iban;
    protected String password;
    protected double sum;

    public Account(int iban, String password, double sum) {
        this.iban = iban;
        this.password = password;
        this.sum = sum;
    }

    public abstract double calcMonthlyDeposit();

    public int getIban() {
        return iban;
    }

    public void setIban(int iban) {
        this.iban = iban;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
