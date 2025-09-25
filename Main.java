public class Main {
    public static void main(String[] args) {
        TimeSpan t1 = new TimeSpan(2, 30);
        TimeSpan t2 = new TimeSpan(1, 45);

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        t1.addTimeSpan(t2);
        System.out.println("t1 + t2 = " + t1);

        t1.scale(2);
        System.out.println("t1 scaled = " + t1);

        t1.subtract(new TimeSpan(3, 0));
        System.out.println("t1 - 3h = " + t1);
    }
}
