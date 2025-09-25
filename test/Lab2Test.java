import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Lab2Test {

    @Test
    void testStudent() {
        Student s = new Student("Іван", 2);
        s.addCourse("Math");
        s.addCourse("Physics");
        assertEquals(2, s.getCourseCount());
        assertEquals("Іван", s.getName());
        assertEquals(40000, s.getTuition());
    }

    @Test
    void testTimeSpan() {
        TimeSpan span = new TimeSpan(2, 30);
        span.add(1, 45);
        assertEquals(4, span.getHours());
        assertEquals(15, span.getMinutes());
        assertEquals(255, span.getTotalMinutes());
    }

    @Test
    void testBankAccount() {
        BankAccount acc1 = new BankAccount();
        acc1.balance = 100;
        acc1.transactionFee = 5;

        BankAccount acc2 = new BankAccount();
        acc2.balance = 50;

        assertTrue(acc1.transfer(acc2, 20));
        assertEquals(75, acc1.getBalance());
        assertEquals(70, acc2.getBalance());
    }
}