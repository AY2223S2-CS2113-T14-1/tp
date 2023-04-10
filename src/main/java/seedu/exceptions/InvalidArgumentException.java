package seedu.exceptions;

//@@author calebcjl
/**
 * Represents an exception that is thrown when user enters an invalid argument for a command.
 */
public class InvalidArgumentException extends Exception {
    private static final String ERROR_MESSAGE = "Invalid input for ";
    private final String invalidArgument;

    public InvalidArgumentException(String invalidArgument) {
        super(invalidArgument);
        this.invalidArgument = invalidArgument;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE + invalidArgument + '!';
    }
}
