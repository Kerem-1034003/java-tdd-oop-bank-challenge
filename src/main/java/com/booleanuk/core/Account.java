package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected List<Transaction> transactions;

    public Account(){
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }
}
