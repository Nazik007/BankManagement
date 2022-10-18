package bankmanagement;

import bankmanagement.model.account.Chequing;
import bankmanagement.model.account.Loan;
import bankmanagement.model.account.Savings;

public class Main {

    public static void main(String[] args) {
        Chequing chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51);
        Savings savings = new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60);
        Loan loan = new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay", 2537.31);

        System.out.println(chequing);
        System.out.println(savings);
        System.out.println(loan);
    }
}
