
public class DateAndTime {

    private Time2 time; 
    private Date date;  

    public DateAndTime() {
        time = new Time2();
        date = new Date();
    }

    public DateAndTime(int hour, int minute, int second, int month, int day, int year) {
        time = new Time2(hour, minute, second);
        date = new Date(month, day, year);
    }

    public void incrementHour() {
        time.incrementHour();  
        if (time.toUniversalString().equals("00:00:00")) { 
            date.incrementDay();
        }
    }

    @Override
    public String toString() {
        return date.toDateString() + " " + time.toString();
    }

    public String toUniversalString() {
        return date.toDateString() + " " + time.toUniversalString();
    }
}

