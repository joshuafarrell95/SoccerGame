package exceptions;

public class TeamLimitReachedException extends Exception {
    private static String exMessage = "ERROR: Team limit of 4 reached.";
    
    public TeamLimitReachedException() {
        super(exMessage);
    }
    
    public TeamLimitReachedException(String message) {
        super(message);
    }
}
