package bankmanagement.model.account;

public class Loan extends Account{

    public Loan (String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    public Loan (Loan source) {
        super(source);
    }

}
