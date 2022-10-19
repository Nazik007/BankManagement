package bankmanagement;

import bankmanagement.model.Bank;
import bankmanagement.model.Transaction;
import bankmanagement.model.account.Chequing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTests {

    Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank();
        bank.addAccount(new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51));
    }

    @Test
    public void successfulTransactions () {
        this.bank.executeTransaction(new Transaction(Transaction.Type.WITHDRAW, 1546905600, "f84c43f4-a634-4c57-a644-7602f8840870", 624.99));
        this.bank.executeTransaction(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 441.93));
        Assertions.assertEquals(2, bank.getTransactions("f84c43f4-a634-4c57-a644-7602f8840870").length);
    }

    @Test
    public void failedTransaction () {
        this.bank.executeTransaction(new Transaction(Transaction.Type.WITHDRAW, 1546905600, "f84c43f4-a634-4c57-a644-7602f8840870", 1000000));
    }

    @Test
    public void taxDeduction () {
        this.bank.executeTransaction(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "f84c43f4-a634-4c57-a644-7602f8840870", 4000));
        this.bank.deductTaxes();
        Assertions.assertEquals(5374.51, bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());
    }
}
