package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Invalid time values");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Cannot add negative values");
        }
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void addTimeSpan(TimeSpan other) {
        if (other == null) throw new NullPointerException("TimeSpan cannot be null");
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
