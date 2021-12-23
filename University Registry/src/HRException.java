/**
 * Exception class for throwing any exception in any of the classes extends the Java exception class
 */
public class HRException extends Exception{

    /**
     * Throws an error with a provided string parameter to inform the user of the exact error.
     *
     * @param message string message based on what error occurred.
     */
    public HRException(String message){
        super(message);}
}
