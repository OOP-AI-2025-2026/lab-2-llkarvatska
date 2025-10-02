package ua.opnu;

public class Main {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("Alice", 500);
        BankAccount b = new BankAccount("Bob", 300);


        a.transfer(b, 100);

        System.out.println(a.getName() + " balance: " + a.getBalance());
        System.out.println(b.getName() + " balance: " + b.getBalance());



        // --- Student demo ---
        Student s = new Student("Іван", 2022);
        s.addCourse("Математика");
        s.addCourse("Програмування");
        System.out.println(s.getName() + ": кількість курсів = " + s.getCourseCount());
    }
}

