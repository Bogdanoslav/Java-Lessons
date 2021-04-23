package block_10.models;

import block_10.abstractClasses.Account;

public class OschadBankAccount extends Account {
    public OschadBankAccount(int iban, String password, double sum) {
        super(iban, password, sum);
    }

    @Override
        public double calcMonthlyDeposit() {
        {
            return this.sum * 0.008;
        }
    }
}
