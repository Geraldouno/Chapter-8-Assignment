
public class TestComplex {
    public static void main(String[] args) {
        Complex num1 = new Complex(3.0, 2.0); 
        Complex num2 = new Complex(1.0, 4.0); 

        System.out.print("Complex number 1: ");
        num1.print(); 

        System.out.print("Complex number 2: ");
        num2.print();  

        Complex sum = num1.add(num2);
        System.out.print("Sum: ");
        sum.print(); 

        Complex difference = num1.subtract(num2);
        System.out.print("Difference: ");
        difference.print(); 
    }
}

