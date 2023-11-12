import java.util.Scanner;

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    @Override
    public String toString() {
        if (real == 0 && imaginary == 0) {
            return "0";
        } else if (real == 0) {
            return (imaginary > 0 ? "" : "-") + imaginary + "i";
        } else if (imaginary == 0) {
            return String.valueOf(real);
        } else {
            return real + (imaginary > 0 ? "+" : "") + imaginary + "i";
        }
    }
}

