package seedu.parser;

import seedu.commands.Command;
import seedu.commands.caloriecommands.AddCalorieCommand;
import seedu.commands.caloriecommands.DeleteCalorieCommand;
import seedu.commands.caloriecommands.ListCaloriesCommand;
import seedu.commands.caloriecommands.ViewCaloriesCommand;
import seedu.handlestringinput.HandleStringInput;

import java.util.Date;
import java.util.regex.Pattern;
import static seedu.parser.Parser.parseDate;
import static seedu.exceptions.message.Messages.INVALID_INPUT_GUIDE;
import static seedu.exceptions.message.Messages.INVALID_CALORIES_INPUT;
import static seedu.exceptions.message.Messages.INVALID_INDEX;
import seedu.exceptions.MultiSlashErrorException;
import seedu.exceptions.InvalidSyntaxException;
import seedu.exceptions.InvalidYearException;
import seedu.exceptions.LongInputException;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.InputContainSpecialCharacter;
import seedu.exceptions.InvalidDateFormatException;
import seedu.exceptions.InvalidDayAndMonthException;
import seedu.exceptions.MissingArgumentException;
import seedu.exceptions.InvalidSpaceNameException;
import seedu.exceptions.InvalidIndexException;
import seedu.exceptions.InvalidCaloriesException;




//@@author calebcjl

/**
 * Represents the parser for calorie commands.
 */
public class CalorieParser {
    private static final int DATE_LENGTH = 8;

    public CalorieParser() {
    }

    //@@author calebcjl

    /**
     * Parses arguments for AddCalorieCommand.
     *
     * @param arguments Arguments to parse.
     * @return AddCalorieCommand.
     * @throws InvalidArgumentException If arguments are invalid.
     */
    public static Command parseAddCalorieCommand(String arguments)
            throws InvalidArgumentException, InvalidSyntaxException, InvalidCaloriesException {
        arguments = arguments.trim();
        Date date;
        String foodName;
        int foodCalories;
        try {
            date = parseDate(arguments.substring(0, DATE_LENGTH));
            if (Pattern.compile("\\D+")
                    .matcher(arguments.substring(arguments.length() - 1)).matches()) {
                return new AddCalorieCommand(date, arguments.substring(DATE_LENGTH).trim());
            }
            foodName = parseFoodName(arguments);
            foodCalories =
                    Integer.parseUnsignedInt(arguments.substring(arguments.lastIndexOf(" ")).trim());
        } catch (NumberFormatException e) {
            throw new InvalidCaloriesException(INVALID_CALORIES_INPUT);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidSyntaxException(INVALID_INPUT_GUIDE);
        } catch (MultiSlashErrorException |
                 InvalidDateFormatException | InvalidYearException | InvalidDayAndMonthException e) {
            throw new RuntimeException(e);
        }
        return new AddCalorieCommand(date, foodName, foodCalories);
    }

    //@@author calebcjl

    /**
     * Parses food name for AddCalorieCommand.
     *
     * @param arguments Arguments to parse.
     * @return Food name.
     * @throws InvalidArgumentException If food name is not valid.
     */
    private static String parseFoodName(String arguments) throws InvalidArgumentException {
        String foodName = arguments.substring(DATE_LENGTH, arguments.lastIndexOf(" ")).trim();
        //@@ author ZIZI-czh
        try {
            HandleStringInput.isValidStringInput(foodName);
        } catch (InputContainSpecialCharacter | InvalidArgumentException | LongInputException |
                 MissingArgumentException | InvalidSpaceNameException e) {
            throw new RuntimeException(e);
        }
        return foodName;
    }


    //@@author Richardtok
    public static Command parseViewCaloriesCommand(String arguments)
            throws InvalidArgumentException, InvalidSyntaxException, MultiSlashErrorException,
            InvalidDateFormatException, InvalidDayAndMonthException, InvalidYearException {
        Date date;
        date = parseDate(arguments.trim());
        return new ViewCaloriesCommand(date);
    }

    //@@author calebcjl

    /**
     * Parses arguments for ListCaloriesCommand.
     *
     * @param arguments Argument for command.
     * @return ListCaloriesCommand.
     * @throws InvalidSyntaxException If invalid syntax.
     */
    public static Command parseListCalorieCommand(String arguments) throws
            InvalidSyntaxException {
        if (!arguments.isBlank()) {
            throw new InvalidSyntaxException(INVALID_INPUT_GUIDE);
        }
        return new ListCaloriesCommand();
    }

    //@@author calebcjl
    /**
     * Parses arguments for DeleteCalorieCommand.
     *
     * @param arguments Argument for command.
     * @return DeleteCalorieCommand.
     * @throws InvalidArgumentException If invalid argument.
     * @throws InvalidSyntaxException   If invalid syntax.
     */
    public static Command parseDeleteCalorieCommand(String arguments)
            throws InvalidArgumentException, InvalidSyntaxException,
            MultiSlashErrorException, InvalidDateFormatException,
            InvalidDayAndMonthException, InvalidYearException, InvalidIndexException {
        arguments = arguments.trim();
        String[] deleteDetails = arguments.split("\\s+");
        Date date = parseDate(deleteDetails[0]);
        if (deleteDetails.length == 1) {
            return new DeleteCalorieCommand(date);
        } else if (deleteDetails.length > 2) {
            throw new InvalidSyntaxException(INVALID_INPUT_GUIDE);
        }

        int index;
        try {
            index = Integer.parseUnsignedInt(deleteDetails[1]) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException(INVALID_INDEX);
        }
        return new DeleteCalorieCommand(date, index);
    }
}
