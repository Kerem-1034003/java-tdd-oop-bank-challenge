package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transaction {
    private LocalDate date;
    private double amount;
    private double balanceAfter;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Transaction(LocalDate date, double amount, double balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    @Override
    public String toString() {
        if (amount > 0) {
            return date.format(formatter) + " || " +
                    String.format(Locale.US, "%.2f", amount) + " || " +
                    String.format(Locale.US, "%.2f", balanceAfter);
        } else {
            return date.format(formatter) + " || " +
                    String.format(Locale.US, "%.2f", Math.abs(amount)) + " || " +
                    String.format(Locale.US, "%.2f", balanceAfter);
        }
    }
}
