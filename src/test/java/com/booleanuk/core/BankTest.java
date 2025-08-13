package com.booleanuk.core;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    static CurrentAccount account;
    @BeforeAll
    static void beforeAll() {
         account = new CurrentAccount();

    }

    @Test
    public void createCurrentAccount(){
//        CurrentAccount account = new CurrentAccount();
        assertNotNull(account, "Account created");
    }

    @Test
    public void newAccount_ShouldHaveNoTransactions(){
      //  CurrentAccount account = new CurrentAccount();
        List<Transaction> transactions = account.getTransactions();
        assertTrue(transactions.isEmpty(), "new account with no Transactions");

    }
}
