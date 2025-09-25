public class TestBank {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Іван", 1000);
        BankAccount acc2 = new BankAccount("Марія", 500);

        acc1.setTransactionFee(10);

        printHeader("Початковий стан");
        printAccounts(acc1, acc2);

        acc1.deposit(200);
        printHeader("Після поповнення Івана на 200");
        printAccounts(acc1, acc2);

        boolean successWithdraw = acc1.withdraw(300);
        printHeader("Спроба зняти 300 (з комісією)");
        System.out.println("Успішно? " + successWithdraw);
        printAccounts(acc1, acc2);

        boolean failWithdraw = acc1.withdraw(2000);
        printHeader("Спроба зняти 2000 (недостатньо коштів)");
        System.out.println("Успішно? " + failWithdraw);
        printAccounts(acc1, acc2);

        boolean transferOk = acc1.transfer(acc2, 400);
        printHeader("Спроба перевести 400 від Івана до Марії (з комісією)");
        System.out.println("Успішно? " + transferOk);
        printAccounts(acc1, acc2);

        boolean transferFail = acc1.transfer(acc2, 5000);
        printHeader("Спроба перевести 5000 (недостатньо коштів)");
        System.out.println("Успішно? " + transferFail);
        printAccounts(acc1, acc2);
    }

    // Допоміжні методи для акуратного виводу
    private static void printHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    private static void printAccounts(BankAccount... accounts) {
        System.out.printf("%-10s | %10s%n", "Власник", "Баланс");
        System.out.println("----------------------------");
        for (BankAccount acc : accounts) {
            System.out.printf("%-10s | %10.2f%n", acc.getOwner(), acc.getBalance());
        }
    }
}
