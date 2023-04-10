package seedu.parser;

import seedu.commands.Command;
import seedu.commands.ExitCommand;
import seedu.commands.caloriecommands.HelpCaloriesCommand;
import seedu.commands.workoutcommands.HelpWorkoutCommand;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.exceptions.message.Messages.MESSAGE_MISSING_ARGUMENT;
import static seedu.exceptions.message.Messages.MESSAGE_COMMAND_UNRECOGNIZABLE;
import static seedu.exceptions.message.Messages.MESSAGE_INVALID_DATE_FORMAT;
import static seedu.exceptions.message.Messages.MESSAGE_CONTAIN_MULTI_SLASH;
import static seedu.exceptions.message.Messages.MESSAGE_INCORRECT_DAY_OR_MONTH;
import static seedu.exceptions.message.Messages.MESSAGE_INCORRECT_YEAR;
import seedu.exceptions.MultiSlashErrorException;
import seedu.exceptions.InvalidSyntaxException;
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

//@@author calebcjl

/**
 * Represents the main parser that parses user commands.
 */
public class Parser {
    private static final Pattern BASIC_COMMAND_FORMAT =
            Pattern.compile("(?<commandName>\\S+)(?<arguments>.*)");


    public static Command processCommand(String userInput) throws InvalidSyntaxException,
            InvalidArgumentException, CommandNotFoundException, MultiSlashErrorException, InvalidDateFormatException,
            InvalidDayAndMonthException, InvalidYearException, MissingArgumentException, InvalidExerciseNameException,
            InvalidWeightException, InvalidNumberForRepsException, EmptyWeightException, InvalidUnitForWeightException,
            InvalidNumberForWeightException, IncorrectWaddCommandException, InvalidIndexException,
            MultiArgumentDetectedException, InvalidCaloriesException {

    public static Command parseCommand(String userInput) throws InvalidSyntaxException, InvalidArgumentException {

        Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new MissingArgumentException(MESSAGE_MISSING_ARGUMENT);
        }

        String commandName = matcher.group("commandName");
        String arguments = matcher.group("arguments");

        //@@author ZIZI-czh
        switch (commandName.toLowerCase()) {
        case "/wstart":
            return WorkoutParser.parseStartWorkoutCommand(arguments);
        case "/wadd":
            return WorkoutParser.parseAddExerciseCommand(arguments);
        case "/wdelete":
            return WorkoutParser.parseDeleteWorkoutCommand(arguments);
        case "/wlist":
            return WorkoutParser.parseListWorkoutCommand(arguments);
        case "/wview":
            return WorkoutParser.parseViewWorkoutCommand(arguments);
        case "/wcount":
            return WorkoutParser.parseSetsRepsCountCommand(arguments);
        case "/wend":
            return WorkoutParser.parseEndWorkoutCommand(arguments);
        case "/whelp":
            return new HelpWorkoutCommand();
        case "/cadd":
            return CalorieParser.parseAddCalorieCommand(arguments);
        case "/clist":
            return CalorieParser.parseListCalorieCommand(arguments);
        case "/cview":
            return CalorieParser.parseViewCaloriesCommand(arguments);
        case "/cdelete":
            return CalorieParser.parseDeleteCalorieCommand(arguments);
        case "/chelp":
            return new HelpCaloriesCommand();
        case "/exit":
            return new ExitCommand();
        default:
            throw new CommandNotFoundException(MESSAGE_COMMAND_UNRECOGNIZABLE);
        }
    }

    /**
     * This method is used to check the input date format
     *
     * @param arguments inputs date
     * @return return null if the date format is invalid
     */
    //@@ author ZIZI-czh
    static Date parseDate(String arguments) throws InvalidDateFormatException,
            MultiSlashErrorException, InvalidYearException, InvalidDayAndMonthException {
        arguments = arguments.trim();
        Date enteredDate;
        try {
            enteredDate = DateFormatter.stringToDate(arguments);
        } catch (ParseException e) {
            throw new InvalidDateFormatException(MESSAGE_INVALID_DATE_FORMAT);
        }

        String[] dateParts = arguments.trim().split("/", 3);
        for (String part : dateParts) {
            if (part.contains("/")) {
                throw new MultiSlashErrorException(MESSAGE_CONTAIN_MULTI_SLASH);
            }
        }
        int day;
        int month;
        int year;

        day = Integer.parseInt(dateParts[0].trim());
        month = Integer.parseInt(dateParts[1].trim());
        year = Integer.parseInt(dateParts[2].trim());
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new InvalidDayAndMonthException(MESSAGE_INCORRECT_DAY_OR_MONTH);
        }
        if (year < 0 || (year > 23 && year < 1000) || year > 2023) {
            throw new InvalidYearException(MESSAGE_INCORRECT_YEAR);
        }

        return enteredDate;
    }
}
