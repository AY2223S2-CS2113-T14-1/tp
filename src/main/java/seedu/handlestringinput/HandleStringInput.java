package seedu.handlestringinput;

import seedu.exceptions.LongInputException;
import seedu.exceptions.InputContainSpecialCharacter;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.MissingArgumentException;
import seedu.exceptions.InvalidSpaceNameException;
import static seedu.exceptions.message.Messages.MESSAGE_LONG_INPUT;
import static seedu.exceptions.message.Messages.MESSAGE_MISSING_ARGUMENT;


public class HandleStringInput {

    public static boolean isInputTooLong(String input) throws LongInputException {

        int maxChars = 20;
        int maxWords = 4;

        String[] words = input.split("\\s+");

        if (words.length > maxWords || input.length() > maxChars) {
            throw new LongInputException(MESSAGE_LONG_INPUT);
        }
        return true;
    }

    public static boolean isValidStringInput(String input) throws
            LongInputException, InputContainSpecialCharacter,
            InvalidArgumentException, MissingArgumentException, InvalidSpaceNameException {
        return isInputTooLong(input) &&
                isValidArgument(input);
    }

    public static boolean isValidArgument(String input)
            throws MissingArgumentException {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            throw new MissingArgumentException(MESSAGE_MISSING_ARGUMENT);
        }
        return true;
    }


}
