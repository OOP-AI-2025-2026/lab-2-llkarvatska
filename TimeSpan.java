public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Години і хвилини мають бути невід’ємні");
        }
        this.hours = hours + minutes / 60;
        this.minutes = minutes % 60;
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Години і хвилини мають бути невід’ємні");
        }
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void addTimeSpan(TimeSpan span) {
        this.hours += span.getHours();
        this.minutes += span.getMinutes();
        normalize();
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void subtract(TimeSpan span) {
        int totalThis = this.getTotalMinutes();
        int totalOther = span.getTotalMinutes();
        if (totalOther > totalThis) {
            throw new IllegalArgumentException("Не можна відняти більший TimeSpan");
        }
        int result = totalThis - totalOther;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Множник має бути додатнім");
        }
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
    }

    @Override
    public String toString() {
        // формат HH:MM з ведучим нулем
        return String.format("%d:%02d", hours, minutes);
    }
}
