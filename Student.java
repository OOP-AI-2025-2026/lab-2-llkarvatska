public class Student {
    private String name;        // ім’я студента
    private int year;           // рік навчання (1-4)
    private String[] courses;   // масив дисциплін
    private int courseCount;    // кількість доданих дисциплін

    // Конструктор
    public Student(String name, int year) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім’я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік має бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new String[20]; // максимум 20 дисциплін
        this.courseCount = 0;
    }

    // Додати дисципліну
    public void addCourse(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            System.out.println("Назва дисципліни некоректна!");
            return;
        }
        if (courseCount < courses.length) {
            courses[courseCount] = courseName;
            courseCount++;
        } else {
            System.out.println("Досягнуто максимуму дисциплін!");
        }
    }

    // Видалити всі дисципліни
    public void dropAll() {
        for (int i = 0; i < courseCount; i++) {
            courses[i] = null;
        }
        courseCount = 0;
    }

    // Повернути кількість дисциплін
    public int getCourseCount() {
        return courseCount;
    }

    // Повернути ім’я
    public String getName() {
        return name;
    }

    // Повернути оплату (20000 грн * рік)
    public int getTuition() {
        return year * 20000;
    }

    // Повернути рік навчання
    public int getYear() {
        return year;
    }
}
