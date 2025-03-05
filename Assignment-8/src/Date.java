
import java.util.HashMap;
import java.util.Map;

public class Date {
    private int month; 
    private int day;   
    private int year;  

    private static final Map<String, Integer> monthMap = new HashMap<>();

    static {
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String monthName, int day, int year) {
        this.month = monthMap.getOrDefault(monthName, 1);
        this.day = day;
        this.year = year;
    }

    public Date(int dayOfYear, int year) {
        this.year = year;
        this.month = 1; 
        this.day = dayOfYear;
        
        int[] daysInMonth = isLeapYear(year) ? 
            new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } : 
            new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 

        for (int i = 0; i < daysInMonth.length; i++) {
            if (dayOfYear <= daysInMonth[i]) {
                this.month = i + 1; 
                this.day = dayOfYear;
                break;
            } else {
                dayOfYear -= daysInMonth[i];
            }
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public String toMMDDYYYY() {
        return String.format("%02d/%02d/%d", month, day, year);
    }

    public String toMonthDayYear() {
        String[] monthNames = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        return String.format("%s %d, %d", monthNames[month], day, year);
    }

    public String toDayOfYearYear() {
        int[] daysInMonth = isLeapYear(year) ? 
            new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } : 
            new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int dayOfYear = 0;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return String.format("%d %d", dayOfYear, year);
    }
}

