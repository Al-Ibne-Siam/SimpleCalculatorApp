package simplecalculator.OtherClasses;

public class Fraction {

    private double numerator;
    private double denominator;
    
    /* 
        This class is used in the conversion of double to fraction
        The double is first converted to numerator by repeatedly multiplying by 10
        The denominator is set to 1 and is multiplied by 10 as many times as the numerator
        Then it goes into the simplifier method which finds common factors and simplifies them
        by dividing with the common factors.
    */

    public Fraction(double n) {
        double den = 1;
        int lim = Double.toString(n).length() - Double.toString(n).indexOf(".");
        for (int i = 1; i < lim; i++) {
            n *= 10;
            den *= 10;
        }
        if (n % (int) n >= 0.5) {   //sometimes due to double's precision and multiplication, the number becomes slightly less
            n = n + 1;                     //Eg. 9 appears as 8.99999 which when casted to int gives 8
        }                                       // so this turns 8.9999 to 9.99999 so that when it is casted back it gives 9
        int[] x = simplifier((int) n, (int) den);
        this.numerator = x[0];
        this.denominator = x[1];

    }

    public static int[] simplifier(int num, int den) {
        for (int i = 2; i < den + 1; i++) {
            while (num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
            }
        }
        return new int[]{num, den};
    }

    @Override
    public String toString() { //Fraction class has been used from my practice project so some string representation here are redundantt
        if (numerator == 0) {
            return (int) 0 + "";
        } else if (denominator == 1 && numerator % (int) numerator == 0) {
            return (int) numerator + "";
        } else if (denominator == 1 && numerator % (int) numerator != 0) {
            return numerator + "";
        } else if (denominator == 0) {
            return "Math Error";
        } else if ((numerator < 0 && denominator < 0) || (numerator > 0 && denominator > 0)) {
            return (int) Math.abs(numerator) + "/" + (int) Math.abs(denominator);
        } else if (numerator > 0 && denominator < 0) {
            return (int) (numerator * -1) + "/" + (int) Math.abs(denominator);
        } else {
            return (int) (numerator) + "/" + (int) Math.abs(denominator);
        }
    }

}
