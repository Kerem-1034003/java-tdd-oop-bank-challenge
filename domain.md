# Domain Model

## Classes

### Account (abstract)
- Variables:
    - `balance: double`
    - `transactions: List<Transaction>`
- Methods:
    - `deposit(amount: double, date: LocalDate)`
    - `withdraw(amount: double, date: LocalDate)`
    - `getTransactions(): List<Transaction>`
    - `getStatement(): List<String>`

### CurrentAccount (extends Account)
- Variables:  -
- Methods: inherits everything from Account

### SavingsAccount (extends Account)
- Variables: -
- Methods: inherits everything from Account

### Transaction
- Variables:
    - `date: LocalDate`
    - `amount: double`
    - `resultingBalance: double`
- Methods:
    - `toString(): String`

## Scenario

1. A customer creates a `SavingsAccount`.
2. The customer deposits €1000 on 13/08/2025.
3. The customer deposits €2000 on 23/09/2025.
4. The customer withdraws €1500 on 25/09/2025.
5. The customer requests the account statement.

## Output

1. 25/09/2025 || 1500.00 || 1500.00
2. 23/09/2025 || 2000.00 || 3000.00
3. 13/08/2025 || 1000.00 || 1000.00


# Class diagram

```
------------------
|   Account      |  <<abstract>>
------------------
| - balance: double
| - transactions: List<Transaction>
------------------
| + deposit(amount: double, date: LocalDate)
| + withdraw(amount: double, date: LocalDate)
| + deposit(amount: double)
| + withdraw(amount: double)
| + getTransactions(): List<Transaction>
| + getStatement(): List<String>
-----------------           
---------------------
                  
------------------    
| CurrentAccount |    
------------------    
| (no extra)     |    
------------------ 

---------------------   

------------------
| SavingsAccount |
-----------------+
| (no extra)     |
------------------

---------------------  

------------------
|  Transaction   |
------------------
| - date: LocalDate
| - amount: double
| - balance: double
------------------
| + toString(): String
------------------
