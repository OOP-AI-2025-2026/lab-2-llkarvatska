package ua.opnu;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough funds");
        }
        balance -= amount;
    }

    //  метод для відсотків
    public void addInterest(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        balance += balance * rate / 100.0;
    }
}

