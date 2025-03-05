
public class Time2 {
    private int totalSeconds; 

    public Time2() {
        this(0, 0, 0); 
    }

    public Time2(int hour) {
        this(hour, 0, 0);
    }

    public Time2(int hour, int minute) {
        this(hour, minute, 0); 
    }

    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.totalSeconds = hour * 3600 + minute * 60 + second; 
    }

    public Time2(Time2 time) {
        this(time.getTotalSeconds()); 
    }
    
    public Time2(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }
    public int getHour() {
        return (totalSeconds / 3600) % 24; 
    }

    public int getMinute() {
        return (totalSeconds % 3600) / 60; 
    }

    public int getSecond() {
        return totalSeconds % 60;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24)
            throw new IllegalArgumentException("hour must be 0-23");
        if (minute < 0 || minute >= 60)
            throw new IllegalArgumentException("minute must be 0-59");
        if (second < 0 || second >= 60)
            throw new IllegalArgumentException("second must be 0-59");

        this.totalSeconds = hour * 3600 + minute * 60 + second;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s", 
            ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
            getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }
}

