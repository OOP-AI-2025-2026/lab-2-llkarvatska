public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}
