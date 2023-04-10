package seedu.exceptions;

//@@author calebcjl
/**
 * Represents an exception that is thrown when user enters an incorrect syntax for a command.
 */
public class InvalidSyntaxException extends Exception {
    private static final String ERROR_MESSAGE = "Syntax error for ";
    private final String syntaxError;

    public InvalidSyntaxException(String syntaxError) {
        super(syntaxError);
        this.syntaxError = syntaxError;
    }

    @Override
    public String toString() {
        return ERROR_MESSAGE + syntaxError + '!';
    }
}
