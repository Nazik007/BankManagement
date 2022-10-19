package bankmanagement;

import bankmanagement.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionTests {

    Transaction transaction;

    @BeforeEach
    public void setup() {
        transaction = new Transaction(Transaction.Type.WITHDRAW , 1546905600, "6b8dd258-aba3-4b19-b238-45d15edd4b48", 624.99);
    }

    @Test
    public void correctDateTest () {
        Assertions.assertEquals("07-01-2019", transaction.returnDate());
    }
}
