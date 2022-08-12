package exceptions;

public class TemperatureTooLowException extends Exception {
    private static String exMessage = "ERROR: Temperature too low.";
    
    public TemperatureTooLowException() {
        super(exMessage);
    }
    
    public TemperatureTooLowException(String message) {
        super(message);
    }
}
