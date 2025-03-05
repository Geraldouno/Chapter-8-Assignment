
public class TestTime {
    public static void main(String[] args) {
        Time2 time1 = new Time2(10, 15, 30); 
        
        Time2 time2 = new Time2(15);
        
        System.out.println("Time1 (Universal): " + time1.toUniversalString());
        System.out.println("Time1 (Standard): " + time1.toString());
        
        System.out.println("Time2 (Universal): " + time2.toUniversalString());
        System.out.println("Time2 (Standard): " + time2.toString());
        
        time1.setTime(5, 30, 45); 
        System.out.println("Updated Time1 (Universal): " + time1.toUniversalString());
        System.out.println("Updated Time1 (Standard): " + time1.toString());
    }
}
