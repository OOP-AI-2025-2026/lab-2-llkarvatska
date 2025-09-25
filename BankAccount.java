public class BankAccount {
    private String owner;
    private double balance;
    private double transactionFee; // комісія за операції

    // Конструктор
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance >= 0 ? balance : 0;
        this.transactionFee = 0.0; // початково 0
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver != null && amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            receiver.balance += amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}