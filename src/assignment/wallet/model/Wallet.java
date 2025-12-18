package assignment.wallet.model;


public class Wallet extends BaseEntity {


    private double balance;


    public Wallet(long id) {
        super(id);
        this.balance = 0.0;
    }


    public void credit(double amount) {
        balance += amount;
    }


    public void debit(double amount) {
        balance -= amount;
    }


    public double getBalance() {
        return balance;
    }
}