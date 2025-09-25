public class Main {
    public static void main(String[] args) {
        // === Перевірка Student ===
        Student student = new Student("Іван", 2);
        student.addCourse("Математика");
        student.addCourse("Програмування");
        student.addCourse("Фізика");

        System.out.println("=== Student ===");
        System.out.println(student.getName() + ": кількість вивчаємих дисциплін - " + student.getCourseCount());
        System.out.println(student.getName() + ": рік навчання - " + student.getYear());
        System.out.println(student.getName() + ": заплатив за навчання - " + student.getTuition());
        System.out.println();

        // === Перевірка TimeSpan ===
        TimeSpan span = new TimeSpan(2, 30);
        span.add(1, 45); // додаємо 1 год 45 хв → буде 4:15
        System.out.println("=== TimeSpan ===");
        System.out.println("Години: " + span.getHours());
        System.out.println("Хвилини: " + span.getMinutes());
        System.out.println("Усього хвилин: " + span.getTotalMinutes());
        System.out.println("Усього годин: " + span.getTotalHours());
        System.out.println();

        // === Перевірка BankAccount ===
        BankAccount acc1 = new BankAccount();
        acc1.balance = 100;
        acc1.transactionFee = 5;

        BankAccount acc2 = new BankAccount();
        acc2.balance = 50;

        System.out.println("=== BankAccount ===");
        System.out.println("Баланс 1 (початковий): " + acc1.getBalance());
        System.out.println("Баланс 2 (початковий): " + acc2.getBalance());

        boolean ok = acc1.transfer(acc2, 20);
        System.out.println("Переказ відбувся: " + ok);
        System.out.println("Баланс 1 (після): " + acc1.getBalance());
        System.out.println("Баланс 2 (після): " + acc2.getBalance());
    }
}
