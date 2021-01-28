package CalculatorExceptions;

public class InvalidNumberException extends Exception{

    public InvalidNumberException() {
        super();
    }

    public InvalidNumberException(String string) {
        super(string);
    }
    
}
