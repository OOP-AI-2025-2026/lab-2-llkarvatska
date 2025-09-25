public class TestBank {
    public static void main(String[] args) {
        BankAccount ivan = new BankAccount("Іван", 1000);
        BankAccount maria = new BankAccount("Марія", 500);

        ivan.setTransactionFee(10);
        maria.setTransactionFee(10);

        System.out.println("=== Початковий стан ===");
        System.out.println(ivan);
        System.out.println(maria);

        ivan.deposit(200);
        System.out.println("\nПісля поповнення Івана на 200:");
        System.out.println(ivan);

        boolean ok1 = ivan.withdraw(300);
        System.out.println("\nСпроба зняти 300 -> " + ok1);
        System.out.println(ivan);

        boolean ok2 = ivan.transfer(maria, 400);
        System.out.println("\nСпроба перевести 400 Іван → Марія -> " + ok2);
        System.out.println(ivan);
        System.out.println(maria);

        boolean ok3 = ivan.transfer(maria, 5000);
        System.out.println("\nСпроба перевести 5000 Іван → Марія -> " + ok3);
        System.out.println(ivan);
        System.out.println(maria);
    }
}
