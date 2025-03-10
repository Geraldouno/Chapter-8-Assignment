
public class TestRectangle {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle();
        System.out.println("Rectangle 1 (By Default):");
        System.out.println("Length: " + rectangle1.getLength());
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Perimeter: " + rectangle1.calculatePerimeter());
        System.out.println("Area: " + rectangle1.calculateArea());
        
        System.out.println();

        Rectangle rectangle2 = new Rectangle(5.0, 10.0);
        System.out.println("Rectangle 2 (5.0 x 10.0):");
        System.out.println("Length: " + rectangle2.getLength());
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Perimeter: " + rectangle2.calculatePerimeter());
        System.out.println("Area: " + rectangle2.calculateArea());
        
        System.out.println();

        rectangle2.setLength(25.0); 
        rectangle2.setWidth(-5.0); 

        System.out.println("Rectangle 2 after invalid inputs:");
        System.out.println("Length: " + rectangle2.getLength());
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Perimeter: " + rectangle2.calculatePerimeter());
        System.out.println("Area: " + rectangle2.calculateArea());
    }
}
