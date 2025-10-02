package ua.opnu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int year;
    private List<String> courses;


    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Year must be 1-4");
        }
        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public int getYear() {
        return year;
    }


    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) { // <-- додав перевірку
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        courses.add(courseName);
    }


    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }


    public int getTuition() {
        return year * 20000;
    }

}
