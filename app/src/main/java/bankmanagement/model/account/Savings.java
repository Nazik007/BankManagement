package bankmanagement.model.account;

public class Savings extends Account {

    public Savings (String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    public Savings (Savings source) {
        super(source);
    }

}
