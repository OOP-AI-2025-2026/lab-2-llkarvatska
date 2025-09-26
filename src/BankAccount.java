public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0.0;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // депозит БЕЗ комісії
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee; // комісія тільки при знятті
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }
        double total = amount + transactionFee; // відправник платить fee
        if (balance >= total) {
            balance -= total;
            receiver.balance += amount; // отримувач отримує рівно amount
            return true;
        }
        return false;
    }
}
