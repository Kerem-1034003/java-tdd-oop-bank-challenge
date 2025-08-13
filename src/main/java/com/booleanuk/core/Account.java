package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class Account {
    protected List<Transaction> transactions;
    protected double balance;

    public Account(){
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void deposit(double amount, String date){
        balance+= amount;
        transactions.add(new Transaction(date, amount, "deposit"));
    }

    public void withdraw(double amount, String date){
        balance -= amount;
        transactions.add(new Transaction(date, amount, "withdraw"));
    }

    public List<String> getStatement() {
        List<String> statement = new ArrayList<>();
        double runningBalance = balance;

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            String line;

            if (t.getType().equals("deposit")) {
                line = String.format(Locale.US, "%s || %.2f || %.2f", t.getDate(), t.getAmount(), runningBalance);
                runningBalance -= t.getAmount();
            } else if (t.getType().equals("withdraw")) {
                line = String.format(Locale.US, "%s || %.2f || %.2f", t.getDate(), t.getAmount(), runningBalance);
                runningBalance += t.getAmount();
            } else {
                continue;
            }
            statement.add(line);
        }

        return statement;
        }

}
