package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Account {
    protected List<Transaction> transactions;
    protected double balance;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Account(){
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void deposit(double amount, LocalDate date) {
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    public void withdraw(double amount, LocalDate date) {
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    public void deposit(double amount) {
        deposit(amount, LocalDate.now());
    }

    public void withdraw(double amount) {
        withdraw(amount, LocalDate.now());
    }

    public List<String> getStatement() {
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        List<String> statementLines = new ArrayList<>();
        for (Transaction t : reversed) {
            statementLines.add(t.toString());
        }
        return statementLines;
    }

}
