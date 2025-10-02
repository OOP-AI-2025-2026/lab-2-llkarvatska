package ua.opnu;

public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee;


    // Конструктор без параметрів (для тестів)
    public BankAccount() {
        this.name = "";
        this.balance = 0.0;
        this.transactionFee = 0.0;
    }



    // Конструктор з параметрами
    public BankAccount(String name, double balance) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0.0;
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


    public void setTransactionFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Fee cannot be negative");
        }
        this.transactionFee = fee;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        balance += amount;
    }


    public boolean withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdraw cannot be negative");
        }
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }


    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null) {
            throw new NullPointerException("Receiver cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount cannot be negative");
        }
        if (balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}
