package ua.opnu;

public class BankAccount {
    private final String name;
    private double balance;
    private double transactionFee;

    public BankAccount() {
        this.name = "";
        this.balance = 0.0;
        this.transactionFee = 0.0;
    }

    public BankAccount(String name, double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0.0;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive");
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null) throw new NullPointerException("Receiver cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Transfer must be positive");

        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            receiver.balance += amount;
            return true;
        }
        return false;
    }

    public void setTransactionFee(double transactionFee) {
        if (transactionFee < 0) throw new IllegalArgumentException("Transaction fee cannot be negative");
        this.transactionFee = transactionFee;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public String getName() {
        return name;
    }
}