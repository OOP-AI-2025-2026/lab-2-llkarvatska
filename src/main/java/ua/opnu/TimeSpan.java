package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0) {
            throw new IllegalArgumentException("Hours must be non-negative");
        }
        if (minutes < 0 || minutes >= 60) { // <-- додав перевірку на minutes >= 60
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        }
        this.hours = hours;
        this.minutes = minutes;
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

    // метод, який вимагають тести
    public void addTimeSpan(TimeSpan other) {
        if (other == null) {
            throw new NullPointerException("TimeSpan cannot be null"); // <-- змінив на NPE
        }
        this.hours += other.hours;
        this.minutes += other.minutes;
        normalize();
    }

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}
