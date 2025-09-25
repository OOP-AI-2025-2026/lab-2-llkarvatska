import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final int year;
    private final List<String> courses;

    public Student(String name, int year) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ім’я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання має бути від 1 до 4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни некоректна!");
        }
        if (!courses.contains(courseName)) {
            courses.add(courseName);
        }
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return year * 20000;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + " (рік " + year + "), дисципліни: " + courses;
    }
}
