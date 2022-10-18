import bankmanagement.model.account.Account;
import bankmanagement.model.account.Chequing;
import bankmanagement.model.account.Loan;
import bankmanagement.model.account.Savings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTests {

    Account [] accounts;

    @BeforeEach
    public void setup () {
        accounts = new Account[] {
                new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51),
                new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60),
                new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay", 2537.31)
        };
    }

    @Test
    public void withdrawal () {
        accounts[0].withdraw(1440);
        Assertions.assertEquals(84.51, accounts[0].getBalance());
    }

    @Test
    public void overdraft () {
        accounts[0].withdraw(1534.43);
        Assertions.assertEquals(-15.42, accounts[0].getBalance());
    }

    @Test
    public void overdraftLimit () {
        accounts[0].withdraw(1726);
        Assertions.assertEquals(1524.51, accounts[0].getBalance());
    }

    @Test
    public void withdrawalFee () {
        accounts[1].withdraw(100);
        Assertions.assertEquals(2136.60, accounts[1].getBalance());
    }

    @Test
    public void withdrawalInterest () {
        accounts[2].withdraw(2434.31);
        Assertions.assertEquals(5020.31, accounts[2].getBalance());
    }

    @Test
    public void withdrawalLimit () {
        accounts[2].withdraw(7463.96);
        Assertions.assertEquals(2537.31, accounts[2].getBalance());
    }

    @Test
    public void deposit () {
        accounts[0].deposit(5000);
        Assertions.assertEquals(6524.51, accounts[0].getBalance());
    }

    @Test
    public void loadDeposit () {
        accounts[2].deposit(1000);
        Assertions.assertEquals(1537.31, accounts[2].getBalance());
    }
}
