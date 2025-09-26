public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee;

    // Конструктор
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactionFee = 0; // за замовчуванням 0
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    // Депозит
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Зняття грошей
    public boolean withdraw(double amount) {
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

    // Переказ грошей
    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }
        double total = amount + t
