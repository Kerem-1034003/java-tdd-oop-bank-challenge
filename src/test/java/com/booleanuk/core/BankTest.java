package com.booleanuk.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BankTest {
    CurrentAccount currentAccount;
    SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount();
        savingsAccount = new SavingsAccount();
    }

    @Test
    public void createCurrentAccount(){
        assertNotNull(currentAccount, "Current account created");
    }

    @Test
    public void newCurrentAccount_ShouldHaveNoTransactions(){
        List<Transaction> transactions = currentAccount.getTransactions();
        assertTrue(transactions.isEmpty(), "new current account with no Transactions");
    }

    @Test
    public void createSavingsAccount(){
        assertNotNull(savingsAccount, "Savings account created");
    }

    @Test
    public void newSavingsAccount_ShouldHaveNoTransactions(){
        List<Transaction> transactions = savingsAccount.getTransactions();
        assertTrue(transactions.isEmpty(), "new savings account with no Transactions");
    }

    @Test
    public void savingsAccount_statement_ShouldDisplayAllTransactionsWithBalance(){
        savingsAccount.deposit(1000, LocalDate.of(2025, 8, 13));
        savingsAccount.deposit(2000, LocalDate.of(2025, 9, 23));
        savingsAccount.withdraw(1500, LocalDate.of(2025, 9, 25));

        List<String> statement = savingsAccount.getStatement();

        assertEquals("25/09/2025 || 1500.00 || 1500.00", statement.get(0));
        assertEquals("23/09/2025 || 2000.00 || 3000.00", statement.get(1));
        assertEquals("13/08/2025 || 1000.00 || 1000.00", statement.get(2));

    }

    @Test
    public void currentAccount_statement_ShouldDisplayAllTransactionsWithBalance(){
        currentAccount.deposit(10000, LocalDate.of(2025, 8, 12));
        currentAccount.withdraw(1000, LocalDate.of(2025, 8, 13));
        currentAccount.withdraw(2000, LocalDate.of(2025, 9, 23));
        currentAccount.deposit(1500, LocalDate.of(2025, 9, 25));

        List<String> statement2 = currentAccount.getStatement();

        assertEquals("25/09/2025 || 1500.00 || 8500.00", statement2.get(0));
        assertEquals("23/09/2025 || 2000.00 || 7000.00", statement2.get(1));
        assertEquals("13/08/2025 || 1000.00 || 9000.00", statement2.get(2));
        assertEquals("12/08/2025 || 10000.00 || 10000.00", statement2.get(3));
    }
}
