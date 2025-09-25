public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("Оля", 2);

        s1.addCourse("Математика");
        s1.addCourse("Програмування");
        s1.addCourse("Математика"); // не додасть вдруге

        System.out.println("Студент: " + s1.getName());
        System.out.println("Рік: " + s1.getYear());
        System.out.println("Кількість курсів: " + s1.getCourseCount());
        System.out.println("Дисципліни: " + s1.getCourses());
        System.out.println("Оплата: " + s1.getTuition());

        s1.dropAll();
        System.out.println("\nПісля видалення всіх дисциплін:");
        System.out.println(s1);
    }
}

