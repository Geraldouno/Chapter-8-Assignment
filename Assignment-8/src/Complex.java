
public class Complex {
    private double realPart;
    private double imaginaryPart;

    public Complex() {
        realPart = 0.0;
        imaginaryPart = 0.0;
    }

    public Complex(double real, double imaginary) {
        realPart = real;
        imaginaryPart = imaginary;
    }

    public Complex add(Complex other) {
        double newReal = this.realPart + other.realPart;
        double newImaginary = this.imaginaryPart + other.imaginaryPart;
        return new Complex(newReal, newImaginary);
    }

    public Complex subtract(Complex other) {
        double newReal = this.realPart - other.realPart;
        double newImaginary = this.imaginaryPart - other.imaginaryPart;
        return new Complex(newReal, newImaginary);
    }

    public void print() {
        System.out.println("(" + realPart + ", " + imaginaryPart + ")");
    }
}

