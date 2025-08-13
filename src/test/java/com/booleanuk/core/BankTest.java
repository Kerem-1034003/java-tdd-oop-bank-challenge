package com.booleanuk.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    static CurrentAccount currentAccount;
    static SavingsAccount savingsAccount;

    @BeforeAll
    static void beforeAll() {
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
}
