public class Main {
    public static void main(String[] args) {
        TimeSpan t1 = new TimeSpan(1, 30);  // 1:30
        TimeSpan t2 = new TimeSpan(2, 45);  // 2:45

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        t1.addTimeSpan(t2);
        System.out.println("\nПісля додавання t2 до t1: " + t1);

        t1.subtract(new TimeSpan(2, 0));
        System.out.println("Після віднімання 2:00: " + t1);

        t1.scale(3);
        System.out.println("Після множення на 3: " + t1);

        System.out.println("\nЗагальні хвилини t1: " + t1.getTotalMinutes());
        System.out.println("Загальні години t1: " + t1.getTotalHours());
    }
}
