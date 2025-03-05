
public class TestDateAndTime {
    public static void main(String[] args) {
        DateAndTime dateAndTime = new DateAndTime(23, 59, 50, 12, 31, 2023);

        System.out.println("Initial Date and Time: " + dateAndTime.toString());

        for (int i = 0; i < 20; i++) {  
            dateAndTime.incrementHour();
            System.out.println("After " + (i + 1) + " hour(s): " + dateAndTime.toString());
        }
    }
}

