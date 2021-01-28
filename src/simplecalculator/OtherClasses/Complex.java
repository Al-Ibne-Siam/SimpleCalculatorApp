package simplecalculator.OtherClasses;

public class Complex {
    /*
        This class is used for complex operations as well as in the quadratic equation when
        the discrimianant<0 by returning a complex number
    */
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (real == 0 && imaginary == 0) {
            return "0"; //when both number is 0
        } else if (real == 0) {
            return imaginary + " i";    //if real is 0, no need to print it
        } else if (imaginary == 0) {
            return real + "";   //if imaginary is 0 no need to print it
        }
        if (imaginary > 0) {
            return real + " +" + imaginary + "i";   //if imaginary>0, need to add a plus sign
        } else {
            return real + " " + imaginary + "i";    //no need to add any sign as - is already infront of imaginary
        }
    }

    public static Complex addComplex(Complex a, Complex b) {
        return new Complex((a.real + b.real), (a.imaginary + b.imaginary));
    }

    public static Complex subtractComplex(Complex a, Complex b) {
        return new Complex((a.real - b.real), (a.imaginary - b.imaginary));
    }

    public static Complex multiplyComplex(Complex a, Complex b) {
        return new Complex(
                (a.real * b.real - a.imaginary * b.imaginary),
                (a.real * b.imaginary + b.real * a.imaginary)
        );
    }

    public static Complex divideComplex(Complex a, Complex b) {
        return new Complex(
                (a.real * b.real + a.imaginary * b.imaginary)
                / (b.real * b.real + b.imaginary * b.imaginary),
                (a.imaginary * b.real - a.real * b.imaginary)
                / (b.real * b.real + b.imaginary * b.imaginary)
        );
    }
}
