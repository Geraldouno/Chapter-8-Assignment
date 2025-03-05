
public class TestHugeInteger {
    public static void main(String[] args) {
        HugeInteger num1 = new HugeInteger();
        num1.parse("1234567890123456789012345678901234");

        HugeInteger num2 = new HugeInteger();
        num2.parse("9876543210987654321098765432109876");

        System.out.println("Num1: " + num1.toString());
        System.out.println("Num2: " + num2.toString());

        HugeInteger sum = num1.add(num2);
        System.out.println("Sum: " + sum.toString());

        HugeInteger difference = num1.subtract(num2);
        System.out.println("Difference: " + difference.toString());

        System.out.println("Num1 is equal to Num2: " + num1.isEqualTo(num2));
        System.out.println("Num1 is greater than Num2: " + num1.isGreaterThan(num2));
    }
} 

