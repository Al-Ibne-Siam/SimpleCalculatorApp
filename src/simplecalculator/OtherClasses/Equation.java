package simplecalculator.OtherClasses;

import simplecalculator.OtherClasses.Complex;

public class Equation {

    public static String DoubleVariable(double a, double b, double c, double d, double e, double f) {
        return "x=" + ((e * c - b * f) / (e * a - b * d))
                + "    y=" + ((c * d - a * f) / (b * d - e * a));
    }

    public static String TripleVariable(double a, double b, double c, double d,
            double e, double f, double g, double h,
            double i, double j, double k, double l) {

        return "x=" + ((((b * k * h + c * f * l + d * g * j) - (b * g * l + c * j * h + d * f * k))
                / ((a * f * k + b * i * g + c * e * j) - (a * g * j + b * e * k + c * f * i))) * -1.0)
                + "    y=" + ((((a * g * l + c * i * h + d * e * k) - (a * k * h + c * e * l + d * g * i))
                / ((a * f * k + b * i * g + c * e * j) - (a * g * j + b * e * k + c * f * i))) * -1.0)
                + "    z=" + ((((a * j * h + b * e * l + d * f * i) - (a * f * l + b * i * h + d * e * j))
                / ((a * f * k + b * i * g + c * e * j) - (a * g * j + b * e * k + c * f * i))) * -1.0);

    }

    public static String quadratic(double a, double b, double c) {
        double disc = Math.pow(b, 2) - 4.0 * a * c;
        if (disc == 0) {
            double x = ((-1 * b) / (2.0 * a));
            return "x1=x2=" + x;
        } else if (disc > 0) {
            double x1 = (((-1.0 * b) + Math.sqrt(disc)) / (2.0 * a));
            double x2 = (((-1.0 * b) - Math.sqrt(disc)) / (2.0 * a));
            return "x1=" + x1 + "\nx2=" + x2;
        } else {
            Complex x1 = new Complex(((b * -1.0) / (2.0 * a)), Math.sqrt(disc * -1.0) / (2.0 * a));
            Complex x2 = new Complex(((b * -1.0) / (2.0 * a)), 1.0 * Math.sqrt(disc * -1.0) / (-2.0 * a));
            return "x1=" + x1 + "\nx2=" + x2;
        }
    }

}
