package com.booleanuk.core;

import java.util.List;
import java.util.ArrayList;

public class CurrentAccount {
    private List<Transaction> transactions;

    public CurrentAccount(){
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

}
