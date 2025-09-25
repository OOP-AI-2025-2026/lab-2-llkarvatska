public class BankAccount {
    private final String owner;
    private double balance;
    private double transactionFee; // комісія

    public BankAccount(String owner, double balance) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Власник не може бути порожнім");
        }
        this.owner = owner;
        this.balance = Math.max(balance, 0);
        this.transactionFee = 0.0;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += (amount - transactionFee >= 0 ? amount - transactionFee : 0);
        }
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

    @Override
    public String toString() {
        return owner + ": " + String.format("%.2f", balance);
    }
}
