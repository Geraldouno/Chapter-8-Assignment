
public class TestDate {
    public static void main(String[] args) {
        Date date1 = new Date(6, 14, 1992); // MM/DD/YYYY format
        Date date2 = new Date("June", 14, 1992); // Month Day, Year format
        Date date3 = new Date(165, 2023); // Day of Year and Year format
        
        System.out.println("Date 1 (MM/DD/YYYY): " + date1.toMMDDYYYY());
        System.out.println("Date 2 (Month Day, Year): " + date2.toMonthDayYear());
        System.out.println("Date 3 (Day of Year Year): " + date3.toDayOfYearYear());
    }
}

