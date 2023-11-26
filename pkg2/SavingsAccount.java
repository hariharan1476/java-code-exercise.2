package pkg2;

import pkg1.Account;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double interestRate) {
        super(accountNumber, accountHolder);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        balance += (balance * interestRate);
    }
}
