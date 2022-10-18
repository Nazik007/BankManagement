package bankmanagement.model.account;

public class Chequing extends Account {

    public Chequing (String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    public Chequing (Chequing source) {
        super(source);
    }


}
