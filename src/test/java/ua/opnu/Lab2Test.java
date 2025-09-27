package ua.opnu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Lab2Test {

    @Nested
    @DisplayName("Tests for TimeSpan task")
    class TimeSpanTest {

        @Test
        @DisplayName("Test constructor with valid input")
        void test1() {
            TimeSpan t = new TimeSpan(2, 30);
            Assertions.assertEquals("2h 30m", t.toString());
        }

        @Test
        @DisplayName("Test constructor with zero minutes")
        void test2() {
            TimeSpan t = new TimeSpan(2, 0);
            Assertions.assertEquals("2h 0m", t.toString());
        }

        @Test
        @DisplayName("Test constructor with minutes >= 60")
        void test3() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new TimeSpan(2, 60));
        }

        @Test
        @DisplayName("Test constructor with negative minutes")
        void test4() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new TimeSpan(2, -5));
        }

        @Test
        @DisplayName("Test constructor with negative hours")
        void test5() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new TimeSpan(-1, 10));
        }

        @Test
        @DisplayName("Test add method simple case")
        void test6() {
            TimeSpan t = new TimeSpan(2, 30);
            t.add(1, 15);
            Assertions.assertEquals("3h 45m", t.toString());
        }

        @Test
        @DisplayName("Test add method with minute overflow")
        void test7() {
            TimeSpan t = new TimeSpan(2, 50);
            t.add(0, 20);
            Assertions.assertEquals("3h 10m", t.toString());
        }

        @Test
        @DisplayName("Test add method with hours only")
        void test8() {
            TimeSpan t = new TimeSpan(1, 10);
            t.add(2, 0);
            Assertions.assertEquals("3h 10m", t.toString());
        }

        @Test
        @DisplayName("Test add method with minutes only")
        void test9() {
            TimeSpan t = new TimeSpan(1, 10);
            t.add(0, 30);
            Assertions.assertEquals("1h 40m", t.toString());
        }

        @Test
        @DisplayName("Test add method with zero")
        void test10() {
            TimeSpan t = new TimeSpan(1, 10);
            t.add(0, 0);
            Assertions.assertEquals("1h 10m", t.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan simple")
        void test11() {
            TimeSpan t1 = new TimeSpan(1, 30);
            TimeSpan t2 = new TimeSpan(2, 15);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("3h 45m", t1.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan with overflow")
        void test12() {
            TimeSpan t1 = new TimeSpan(1, 50);
            TimeSpan t2 = new TimeSpan(0, 20);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("2h 10m", t1.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan with zero")
        void test13() {
            TimeSpan t1 = new TimeSpan(1, 50);
            TimeSpan t2 = new TimeSpan(0, 0);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("1h 50m", t1.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan with only hours")
        void test14() {
            TimeSpan t1 = new TimeSpan(1, 50);
            TimeSpan t2 = new TimeSpan(2, 0);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("3h 50m", t1.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan with only minutes")
        void test15() {
            TimeSpan t1 = new TimeSpan(1, 50);
            TimeSpan t2 = new TimeSpan(0, 5);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("1h 55m", t1.toString());
        }

        @Test
        @DisplayName("Test multiple adds")
        void test16() {
            TimeSpan t = new TimeSpan(0, 0);
            t.add(1, 30);
            t.add(2, 45);
            Assertions.assertEquals("4h 15m", t.toString());
        }

        @Test
        @DisplayName("Test multiple addTimeSpan")
        void test17() {
            TimeSpan t1 = new TimeSpan(0, 0);
            t1.addTimeSpan(new TimeSpan(1, 30));
            t1.addTimeSpan(new TimeSpan(2, 45));
            Assertions.assertEquals("4h 15m", t1.toString());
        }

        @Test
        @DisplayName("Test toString for zero")
        void test18() {
            TimeSpan t = new TimeSpan(0, 0);
            Assertions.assertEquals("0h 0m", t.toString());
        }

        @Test
        @DisplayName("Test toString for only hours")
        void test19() {
            TimeSpan t = new TimeSpan(5, 0);
            Assertions.assertEquals("5h 0m", t.toString());
        }

        @Test
        @DisplayName("Test toString for only minutes")
        void test20() {
            TimeSpan t = new TimeSpan(0, 45);
            Assertions.assertEquals("0h 45m", t.toString());
        }

        @Test
        @DisplayName("Test chaining add and addTimeSpan")
        void test21() {
            TimeSpan t = new TimeSpan(1, 0);
            t.add(0, 30);
            t.addTimeSpan(new TimeSpan(2, 45));
            Assertions.assertEquals("4h 15m", t.toString());
        }

        @Test
        @DisplayName("Test large values")
        void test22() {
            TimeSpan t = new TimeSpan(100, 59);
            Assertions.assertEquals("100h 59m", t.toString());
        }

        @Test
        @DisplayName("Test adding large values")
        void test23() {
            TimeSpan t = new TimeSpan(100, 59);
            t.add(10, 1);
            Assertions.assertEquals("111h 0m", t.toString());
        }

        @Test
        @DisplayName("Test adding with multiple overflows")
        void test24() {
            TimeSpan t = new TimeSpan(1, 59);
            t.add(0, 121);
            Assertions.assertEquals("4h 0m", t.toString());
        }

        @Test
        @DisplayName("Test equality of TimeSpans after operations")
        void test25() {
            TimeSpan t1 = new TimeSpan(2, 30);
            TimeSpan t2 = new TimeSpan(1, 15);
            t1.addTimeSpan(t2);
            Assertions.assertEquals("3h 45m", t1.toString());
        }

        @Test
        @DisplayName("Test complex chain")
        void test26() {
            TimeSpan t = new TimeSpan(0, 0);
            t.add(0, 59);
            t.add(0, 59);
            t.add(0, 59);
            Assertions.assertEquals("2h 57m", t.toString());
        }

        @Test
        @DisplayName("Test complex chain with overflow")
        void test27() {
            TimeSpan t = new TimeSpan(0, 0);
            t.add(0, 120);
            t.add(1, 0);
            Assertions.assertEquals("3h 0m", t.toString());
        }

        @Test
        @DisplayName("Test multiple TimeSpans")
        void test28() {
            TimeSpan t = new TimeSpan(1, 1);
            t.addTimeSpan(new TimeSpan(2, 2));
            t.addTimeSpan(new TimeSpan(3, 3));
            Assertions.assertEquals("6h 6m", t.toString());
        }

        @Test
        @DisplayName("Test negative case add minutes")
        void test29() {
            TimeSpan t = new TimeSpan(1, 1);
            Assertions.assertThrows(IllegalArgumentException.class, () -> t.add(1, -5));
        }

        @Test
        @DisplayName("Test negative case add hours")
        void test30() {
            TimeSpan t = new TimeSpan(1, 1);
            Assertions.assertThrows(IllegalArgumentException.class, () -> t.add(-2, 10));
        }

        @Test
        @DisplayName("Test negative case addTimeSpan null")
        void test31() {
            TimeSpan t = new TimeSpan(1, 1);
            Assertions.assertThrows(NullPointerException.class, () -> t.addTimeSpan(null));
        }

        @Test
        @DisplayName("Test constructor with both zero")
        void test32() {
            TimeSpan t = new TimeSpan(0, 0);
            Assertions.assertEquals("0h 0m", t.toString());
        }

        @Test
        @DisplayName("Test add zero")
        void test33() {
            TimeSpan t = new TimeSpan(5, 5);
            t.add(0, 0);
            Assertions.assertEquals("5h 5m", t.toString());
        }

        @Test
        @DisplayName("Test addTimeSpan zero")
        void test34() {
            TimeSpan t = new TimeSpan(5, 5);
            t.addTimeSpan(new TimeSpan(0, 0));
            Assertions.assertEquals("5h 5m", t.toString());
        }

        @Test
        @DisplayName("Test long chain")
        void test35() {
            TimeSpan t = new TimeSpan(0, 0);
            for (int i = 0; i < 10; i++) {
                t.add(0, 10);
            }
            Assertions.assertEquals("1h 40m", t.toString());
        }

        @Test
        @DisplayName("Test add edge minutes")
        void test36() {
            TimeSpan t = new TimeSpan(1, 59);
            t.add(0, 1);
            Assertions.assertEquals("2h 0m", t.toString());
        }

        @Test
        @DisplayName("Test constructor borderline")
        void test37() {
            TimeSpan t = new TimeSpan(0, 59);
            Assertions.assertEquals("0h 59m", t.toString());
        }

        @Test
        @DisplayName("Test constructor borderline 2")
        void test38() {
            TimeSpan t = new TimeSpan(1, 59);
            Assertions.assertEquals("1h 59m", t.toString());
        }

        @Test
        @DisplayName("Test multiple add with overflow")
        void test39() {
            TimeSpan t = new TimeSpan(0, 50);
            t.add(0, 20);
            t.add(0, 20);
            Assertions.assertEquals("1h 30m", t.toString());
        }

        @Test
        @DisplayName("Test mixed add and addTimeSpan")
        void test40() {
            TimeSpan t = new TimeSpan(0, 50);
            t.add(0, 20);
            t.addTimeSpan(new TimeSpan(0, 20));
            Assertions.assertEquals("1h 30m", t.toString());
        }

        @Test
        @DisplayName("Test chained adds and resets")
        void test41() {
            TimeSpan t = new TimeSpan(0, 0);
            t.add(0, 30);
            t.add(0, 30);
            t.add(0, 60);
            Assertions.assertEquals("2h 0m", t.toString());
        }

        @Test
        @DisplayName("Test add 59 minutes repeatedly")
        void test42() {
            TimeSpan t = new TimeSpan(0, 0);
            t.add(0, 59);
            t.add(0, 59);
            Assertions.assertEquals("1h 58m", t.toString());
        }
    }

    @Nested
    @DisplayName("Tests for BankAccount")
    class BankAccountTest {

        @Test
        @DisplayName("Test deposit positive")
        void test1() {
            BankAccount acc = new BankAccount();
            acc.deposit(100.0);
            Assertions.assertEquals(100.0, acc.getBalance());
        }

        @Test
        @DisplayName("Test deposit negative")
        void test2() {
            BankAccount acc = new BankAccount();
            Assertions.assertThrows(IllegalArgumentException.class, () -> acc.deposit(-50.0));
        }

        @Test
        @DisplayName("Test withdraw success")
        void test3() {
            BankAccount acc = new BankAccount();
            acc.deposit(100.0);
            boolean result = acc.withdraw(50.0);
            Assertions.assertTrue(result);
            Assertions.assertEquals(50.0, acc.getBalance());
        }

        @Test
        @DisplayName("Test withdraw fail")
        void test4() {
            BankAccount acc = new BankAccount();
            acc.deposit(100.0);
            boolean result = acc.withdraw(150.0);
            Assertions.assertFalse(result);
            Assertions.assertEquals(100.0, acc.getBalance());
        }

        @Test
        @DisplayName("Test withdraw negative")
        void test5() {
            BankAccount acc = new BankAccount();
            acc.deposit(100.0);
            Assertions.assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-10.0));
        }

        @Test
        @DisplayName("Test transfer success")
        void test6() {
            BankAccount a = new BankAccount();
            a.deposit(200.0);
            BankAccount b = new BankAccount();
            a.transfer(b, 100.0);
            Assertions.assertEquals(100.0, a.getBalance());
            Assertions.assertEquals(100.0, b.getBalance());
        }

        @Test
        @DisplayName("Test transfer fail")
        void test7() {
            BankAccount a = new BankAccount();
            a.deposit(50.0);
            BankAccount b = new BankAccount();
            boolean res = a.transfer(b, 100.0);
            Assertions.assertFalse(res);
            Assertions.assertEquals(50.0, a.getBalance());
            Assertions.assertEquals(0.0, b.getBalance());
        }

        @Test
        @DisplayName("Test transfer with fee")
        void test8() {
            BankAccount a = new BankAccount();
            a.deposit(200.0);
            a.setTransactionFee(1.0);
            BankAccount b = new BankAccount();
            a.transfer(b, 100.0);
            Assertions.assertEquals(99.0, a.getBalance());
            Assertions.assertEquals(100.0, b.getBalance());
        }

        @Test
        @DisplayName("Test transfer insufficient with fee")
        void test9() {
            BankAccount a = new BankAccount();
            a.deposit(100.0);
            a.setTransactionFee(5.0);
            BankAccount b = new BankAccount();
            boolean res = a.transfer(b, 100.0);
            Assertions.assertFalse(res);
            Assertions.assertEquals(100.0, a.getBalance());
            Assertions.assertEquals(0.0, b.getBalance());
        }

        @Test
        @DisplayName("Test multiple deposits")
        void test10() {
            BankAccount acc = new BankAccount();
            acc.deposit(50.0);
            acc.deposit(70.0);
            Assertions.assertEquals(120.0, acc.getBalance());
        }

        @Test
        @DisplayName("Test multiple withdraws")
        void test11() {
            BankAccount acc = new BankAccount();
            acc.deposit(200.0);
            acc.withdraw(50.0);
            acc.withdraw(100.0);
            Assertions.assertEquals(50.0, acc.getBalance());
        }

        @Test
        @DisplayName("Test negative fee")
        void test12() {
            BankAccount acc = new BankAccount();
            Assertions.assertThrows(IllegalArgumentException.class, () -> acc.setTransactionFee(-5.0));
        }

        @Test
        @DisplayName("Test transfer 5")
        void test13() {
            BankAccount first = new BankAccount();
            first.deposit(100.0);
            first.setTransactionFee(5.0);

            BankAccount second = new BankAccount();
            second.deposit(200.0);
            second.setTransactionFee(7.0);

            boolean actual = first.transfer(second, 96.0);

            Assertions.assertFalse(actual);
            Assertions.assertEquals(100.0, first.getBalance());
            Assertions.assertEquals(200.0, second.getBalance());
        }

        @Test
        @DisplayName("Test transfer 6")
        void test14() {
            BankAccount first = new BankAccount();
            first.deposit(100.0);
            first.setTransactionFee(5.0);

            BankAccount second = new BankAccount();
            second.deposit(200.0);
            second.setTransactionFee(7.0);

            boolean actual = first.transfer(second, 95.0);

            Assertions.assertTrue(actual);
            Assertions.assertEquals(0.0, first.getBalance());
            Assertions.assertEquals(295.0, second.getBalance());
        }

        @Test
        @DisplayName("Test getName")
        void test15() {
            BankAccount acc = new BankAccount("Alice", 100.0);
            Assertions.assertEquals("Alice", acc.getName());
        }

    }

    @Nested
    @DisplayName("Tests for Student")
    class StudentTest {

        @Test
        @DisplayName("Constructor with valid arguments")
        void test1() {
            Student s = new Student("Іван", 2);
            Assertions.assertEquals("Іван", s.getName());
            Assertions.assertEquals(2, s.getYear());
            Assertions.assertEquals(0, s.getCourseCount());
        }

        @Test
        @DisplayName("Constructor with invalid name")
        void test2() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("", 1));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Student(null, 1));
        }

        @Test
        @DisplayName("Constructor with invalid year")
        void test3() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Іван", 0));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Student("Іван", 5));
        }

        @Test
        @DisplayName("Add courses and check count")
        void test4() {
            Student s = new Student("Іван", 2);
            s.addCourse("Math");
            s.addCourse("Programming");
            Assertions.assertEquals(2, s.getCourseCount());
        }

        @Test
        @DisplayName("Add invalid course")
        void test5() {
            Student s = new Student("Іван", 2);
            Assertions.assertThrows(IllegalArgumentException.class, () -> s.addCourse(""));
            Assertions.assertThrows(IllegalArgumentException.class, () -> s.addCourse(null));
        }

        @Test
        @DisplayName("Drop all courses")
        void test6() {
            Student s = new Student("Іван", 2);
            s.addCourse("Math");
            s.addCourse("Programming");
            s.dropAll();
            Assertions.assertEquals(0, s.getCourseCount());
        }

        @Test
        @DisplayName("Check tuition calculation")
        void test7() {
            Student s1 = new Student("Іван", 1);
            Assertions.assertEquals(20000, s1.getTuition());

            Student s2 = new Student("Петро", 4);
            Assertions.assertEquals(80000, s2.getTuition());
        }
    }
}
