public class StudentTest {
    public static void main(String[] args) {
        // створюємо студента
        Student st = new Student("Іван", 2);

        // додаємо дисципліни
        st.addCourse("Математика");
        st.addCourse("Програмування");
        st.addCourse("Фізика");

        // вивід
        System.out.println(st.getName() + ": кількість вивчаємих дисциплін - " + st.getCourseCount());
        System.out.println(st.getName() + ": рік навчання - " + st.getYear());
        System.out.println(st.getName() + ": заплатив за навчання - " + st.getTuition());
    }
}
