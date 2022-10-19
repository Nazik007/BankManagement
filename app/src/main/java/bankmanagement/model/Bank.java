package bankmanagement.model;

import bankmanagement.model.account.Account;
import bankmanagement.model.account.Chequing;
import bankmanagement.model.account.impl.Taxable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public Transaction[] getTransactions (String accountId) {
        List<Transaction> list = this.transactions.stream()
                .filter((transaction) -> transaction.getId().equals(accountId))
                .collect(Collectors.toList());

        return list.toArray(new Transaction[list.size()]);
    }

    public Account getAccount (String transactionId) {
        return accounts.stream()
                .filter((account) -> account.getId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }

    public void addAccount (Account account) {
        this.accounts.add(account.clone());
    }

    private void addTransaction (Transaction transaction) {
        this.transactions.add(new Transaction(transaction));
    }

    private void withdrawTransaction(Transaction transaction) {
       if (getAccount(transaction.getId()).withdraw(transaction.getAmount())) {
           addTransaction(transaction);
       }
    }

    public void executeTransaction (Transaction transaction) {
        switch (transaction.getType()) {
            case WITHDRAW -> withdrawTransaction(transaction);
            case DEPOSIT -> depositTransaction(transaction);
        }
    }

    private void depositTransaction(Transaction transaction) {
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);
    }

    public void deductTaxes() {
        for (Account account: accounts) {
            if (Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable) account;
                taxable.tax(getIncome(taxable));
            }
        }
    }

    private double getIncome(Taxable account) {
        Transaction[] transactions = getTransactions(((Chequing)account).getId());
        return Arrays.stream(transactions)
                .mapToDouble((transaction) -> {
                    switch (transaction.getType()) {
                        case WITHDRAW: return -transaction.getAmount();
                        case DEPOSIT: return transaction.getAmount();
                        default: return 0;
                    }
                }).sum();
    }
}
