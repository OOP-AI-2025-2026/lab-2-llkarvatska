public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            return;
        }
        int totalMinutes = this.getTotalMinutes() + hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int current = this.getTotalMinutes();
        int other = span.getTotalMinutes();
        if (other > current) {
            return;
        }
        int result = current - other;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
