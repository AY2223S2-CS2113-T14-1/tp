package seedu.parser;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.commands.Command;
import seedu.commands.ExitCommand;
import seedu.commands.errorcommands.IncorrectSyntaxCommand;
import seedu.exceptions.InvalidSyntaxException;
import seedu.exceptions.MultiSlashErrorException;
import seedu.exceptions.CommandNotFoundException;
import seedu.exceptions.InvalidYearException;
import seedu.exceptions.InvalidExerciseNameException;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.InvalidWeightException;
import seedu.exceptions.InvalidCaloriesException;
import seedu.exceptions.InvalidDateFormatException;
import seedu.exceptions.InvalidDayAndMonthException;
import seedu.exceptions.MissingArgumentException;
import seedu.exceptions.InvalidNumberForRepsException;
import seedu.exceptions.InvalidIndexException;
import seedu.exceptions.EmptyWeightException;
import seedu.exceptions.IncorrectWaddCommandException;
import seedu.exceptions.InvalidNumberForWeightException;
import seedu.exceptions.InvalidUnitForWeightException;
import seedu.exceptions.MultiArgumentDetectedException;


//@@author ZIZI-czh
public class ParserTest {

    /**
     * Test the input for list command
     * if the user type in user /list 556 which is incorrect, then it will show error
     */
    //@@ author ZIZI-czh
    @Test
    public void testProcessCommandIncorrectArguments() {
        String userInput = "/wlist 556";
        Parser testList = new Parser();
        Command result;
        try {

            result = Parser.processCommand(userInput);

            result = testList.parseCommand(userInput);

        } catch (InvalidSyntaxException e) {
            result = new ExitCommand();
        } catch (InvalidArgumentException | MultiSlashErrorException | InvalidDateFormatException |
                 InvalidDayAndMonthException | InvalidYearException | CommandNotFoundException |
                 MissingArgumentException | InvalidWeightException | InvalidNumberForRepsException |
                 InvalidIndexException | MultiArgumentDetectedException | InvalidCaloriesException |
                 EmptyWeightException | InvalidUnitForWeightException | InvalidNumberForWeightException |
                 IncorrectWaddCommandException | InvalidExerciseNameException e) {
            throw new RuntimeException(e);
        }
        //show error, if the result satisfy the condition in IncorrectCommand
        Assertions.assertFalse(result instanceof IncorrectSyntaxCommand);
    }

}
