
public class TestEnhancedTest2 {
    public class Time2Test {
    public static void main(String[] args) {
        // Test case 1: Incrementing into the next minute
        Time2 time1 = new Time2(10, 59, 59); // 10:59:59
        System.out.println("Before tick: " + time1.toUniversalString());
        time1.tick(); // Should increment to 11:00:00
        System.out.println("After tick: " + time1.toUniversalString());
        
        // Test case 2: Incrementing into the next hour
        Time2 time2 = new Time2(11, 59, 59); // 11:59:59
        System.out.println("\nBefore incrementMinute: " + time2.toUniversalString());
        time2.incrementMinute(); // Should increment to 12:00:00
        System.out.println("After incrementMinute: " + time2.toUniversalString());
        
        // Test case 3: Incrementing into the next day (11:59:59 PM to 12:00:00 AM)
        Time2 time3 = new Time2(23, 59, 59); // 23:59:59 (11:59:59 PM)
        System.out.println("\nBefore incrementHour: " + time3.toUniversalString());
        time3.incrementHour(); // Should increment to 00:00:00 (12:00:00 AM)
        System.out.println("After incrementHour: " + time3.toUniversalString());
    }
}
