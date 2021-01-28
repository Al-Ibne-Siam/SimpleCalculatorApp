package Validator;

import CalculatorExceptions.InvalidNumberException;

public class NumberValidator {

    public static boolean NumberValidityChecker(String x) {
        boolean value = true;
        try {
            if (x.equals("")) {
                value = false;
                throw new InvalidNumberException("This is an invalid number");
            }
            if (x.endsWith(".")) {
                value = false;
                throw new InvalidNumberException("This is not a valid number");
            }
            int decimalCount = 0;
            for (char c : x.toCharArray()) {
                if (!((c >= 48 && c <= 57) || c == 46 || c == '-')) {
                    value = false;
                    throw new InvalidNumberException("This is an invalid number");
                }
                if (c == '.') {
                    decimalCount++;
                    if (decimalCount > 1) {
                        value = false;
                        throw new InvalidNumberException("This is an invalid number");
                    }
                }
            }
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        } finally {
            return value;
        }
    }
}
