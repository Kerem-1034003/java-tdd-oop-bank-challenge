package com.booleanuk.core;

public class Transaction {
    private final String date;
    private final double amount;
    private final String type;

    public Transaction(String date, double amount, String type){
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
