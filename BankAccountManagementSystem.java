import java.util.ArrayList;
import java.util.List;

class BankAccount {
    // Attributes
    private String accountNumber;
   
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Initial balance: " + initialBalance);
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposited: " + amount);
            displayBalance();
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Withdrew: " + amount);
            displayBalance();
        }
    }

    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("\nTransaction History for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to check the current balance (without changing it)
    public double checkBalance() {
        return balance;
    }
}

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        // Create multiple BankAccount instances for testing
        BankAccount account1 = new BankAccount("1001", "John Doe", 500.0);
        BankAccount account2 = new BankAccount("1002", "Jane Smith", 1000.0);

        // Test the deposit, withdrawal, and balance checking methods
        account1.deposit(200);         // Deposit into account1
        account1.withdraw(100);        // Withdraw from account1
        account1.withdraw(700);        // Insufficient funds scenario
        account1.displayTransactionHistory();  // Display transaction history for account1

        account2.deposit(500);         // Deposit into account2
        account2.withdraw(1200);       // Withdraw from account2
        account2.withdraw(200);        // Valid withdrawal for account2
        account2.displayTransactionHistory();  // Display transaction history for account2
    }
}


