package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount {
    private List<Transaction> transactions;

    public SavingsAccount() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
