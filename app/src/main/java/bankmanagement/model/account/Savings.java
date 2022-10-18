package bankmanagement.model.account;

public class Savings extends Account {

    private static final double WITHDRAWAL_FEE = 5.00;

    public Savings (String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        super.setBalance(super.round(super.getBalance() - amount - WITHDRAWAL_FEE));
        return true;
    }

    public Savings (Savings source) {
        super(source);
    }

}
