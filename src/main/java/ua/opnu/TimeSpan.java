package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Hours and minutes must be non-negative");
        }
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Hours and minutes must be non-negative");
        }
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void addTimeSpan(TimeSpan other) {
        if (other == null) {
            throw new IllegalArgumentException("TimeSpan cannot be null");
        }
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    // додаткові методи для тестів
    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass
