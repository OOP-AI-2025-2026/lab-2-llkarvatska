package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // TimeSpan
        TimeSpan t1 = new TimeSpan(2, 15);
        TimeSpan t2 = new TimeSpan(1, 45);
        t1.addTimeSpan(t2);
        System.out.println("TimeSpan t1: " + t1); // очікуємо 4h 0m

        // BankAccount
        BankAccount a = new BankAccount("Alice", 200); // створюємо рахунок з балансом
        a.setTransactionFee(1.0);

        BankAccount b = new BankAccount("Bob", 0); // другий рахунок

        a.transfer(b, 100);
        System.out.println(a.getName() + " balance: " + a.getBalance()); // 99.0
        System.out.println(b.getName() + " balance: " + b.getBalance()); // 100.0

        // Student
        Student s = new Student("Іван", 2);
        s.addCourse("Математика");
        s.addCourse("Програмування");
        System.out.println(s.getName() + ": кількість вивчаємих дисциплін - " + s.getCourseCount());
        System.out.println(s.getName() + ": рік навчання - " + s.getYear());
        System.out.println(s.getName() + ": заплатив за навчання - " + s.getTuition());
    }
}
