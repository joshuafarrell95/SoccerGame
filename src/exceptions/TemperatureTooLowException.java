package exceptions;

public class TemperatureTooLowException extends Exception {
    private final int MAXIMUM_TRIES = 3;
    private static String exMessage = "Too cold to play.";
    
    public TemperatureTooLowException() {
        super(exMessage);
    }
    
    public TemperatureTooLowException(String message) {
        super(message);
    }
}
