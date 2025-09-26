public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee = 0.0;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount; // при поповненні комісія НЕ знімається
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee; // комісія діє лише при знятті
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
        double total = amount + transactionFee; // комісія діє при переказі
        if (balance >= total) {
            balance -= total;
            receiver.balance += amount; // отримувач отримує САМЕ amount, без fee
            return true;
        }
        return false;
    }
}
