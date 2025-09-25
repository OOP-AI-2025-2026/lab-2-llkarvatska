import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private List<String> courses;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
        if (year < 1 || year > 4) {
            this.year = 1;
        } else {
            this.year = year;
        }
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        }
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
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
}
