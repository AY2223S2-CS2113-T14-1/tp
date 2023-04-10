package seedu.parser;

import seedu.commands.Command;
import seedu.commands.workoutcommands.ViewWorkoutCommand;
import seedu.commands.workoutcommands.ListWorkoutCommand;
import seedu.commands.workoutcommands.DeleteWorkoutCommand;
import seedu.commands.workoutcommands.EndWorkoutCommand;
import seedu.commands.workoutcommands.AddExerciseCommand;
import seedu.commands.workoutcommands.StartWorkoutCommand;
import seedu.commands.workoutcommands.CountSetsRepsCommand;
import seedu.handlestringinput.HandleStringInput;
import seedu.workout.Exercise;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;
import static seedu.exceptions.message.Messages.INVALID_NUMBER_FOR_RPS;
import static seedu.exceptions.message.Messages.MESSAGE_INVALID_WADD_COMMAND;
import static seedu.exceptions.message.Messages.MESSAGE_EXCEED_MAX_SETS_FOR_RPS;
import static seedu.exceptions.message.Messages.INVALID_INDEX;
import static seedu.exceptions.message.Messages.MULTI_ARGUMENT;
import seedu.exceptions.MultiSlashErrorException;
import seedu.exceptions.InvalidSyntaxException;
import seedu.exceptions.IncorrectWaddCommandException;
import seedu.exceptions.InvalidYearException;
import seedu.exceptions.LongInputException;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.InputContainSpecialCharacter;
import seedu.exceptions.InvalidWeightException;
import seedu.exceptions.InvalidDateFormatException;
import seedu.exceptions.InvalidDayAndMonthException;
import seedu.exceptions.MissingArgumentException;
import seedu.exceptions.InvalidSpaceNameException;
import seedu.exceptions.InvalidIndexException;
import seedu.exceptions.ExceedMaxRpsSetsException;
import seedu.exceptions.MultiArgumentDetectedException;
import seedu.exceptions.InvalidNumberForRepsException;
import static seedu.parser.Parser.parseDate;

/**
 * Represents the parser for workout commands.
 */
public class WorkoutParser {
    private static final int EXERCISE_NAME_INDEX = 0;
    private static final int WEIGHT_INDEX = 1;
    private static final int REPS_PER_SET_INDEX = 2;
    private static final int ADD_ARGUMENT_COUNT = 3;

    private static final int MAX_SETS_FOR_RPS = 15;


    //@@author calebcjl

    /**
     * Parse arguments for /wadd command.
     *
     * @param arguments Arguments for add workout command.
     * @return AddWorkoutCommand if arguments are valid.
     * @throws InvalidSyntaxException If there is invalid syntax.
     */
    static Command parseAddExerciseCommand(String arguments)

            throws InvalidArgumentException, IncorrectWaddCommandException,
            InvalidWeightException, InvalidNumberForRepsException {
        //exercise name 100kg 5 5 5 5

            throws InvalidSyntaxException, InvalidArgumentException {

        String[] exerciseDetails = new String[ADD_ARGUMENT_COUNT];
        Matcher matcher = Pattern.compile("\\d+").matcher(arguments);
        matcher.find();
        try {
            exerciseDetails[EXERCISE_NAME_INDEX] = arguments.substring(0, arguments.indexOf(matcher.group()));
            exerciseDetails[WEIGHT_INDEX] = arguments.substring(arguments.indexOf(matcher.group()),
                    max(arguments.indexOf("kg"), arguments.indexOf("lb")) + 2);
            exerciseDetails[REPS_PER_SET_INDEX] = arguments.substring
                    (arguments.indexOf(exerciseDetails[WEIGHT_INDEX])
                            + exerciseDetails[WEIGHT_INDEX].length());
        } catch (IndexOutOfBoundsException | IllegalStateException e) {
            throw new IncorrectWaddCommandException(MESSAGE_INVALID_WADD_COMMAND);
        }

        String exerciseName = parseExerciseName(exerciseDetails[EXERCISE_NAME_INDEX]);
        String weight = parseWeight(exerciseDetails[WEIGHT_INDEX]);
        String repsPerSet = parseRepsPerSet(exerciseDetails[REPS_PER_SET_INDEX]);

        Exercise toAdd = new Exercise(exerciseName, weight, repsPerSet);

        return new AddExerciseCommand(toAdd);
    }

    //@@author calebcjl

    /**
     * Parses exercise name argument.
     * Removes any leading and trailing whitespaces.
     *
     * @param exerciseName Exercise name argument.
     * @return Exercise name.
     * @throws InvalidArgumentException If syntax is invalid.
     */
    private static String parseExerciseName(String exerciseName) {
        exerciseName = exerciseName.trim();
        try {
            //@@author ZIZI-czh
            HandleStringInput.isInputTooLong(exerciseName);

        } catch (LongInputException e) {
            throw new RuntimeException(e);
        }
        return exerciseName;
    }

    //@@author calebcjl
    /**
     * Checks if weight is valid.
     * A valid weight contains a positive number with at most 2 decimal place and weight unit (kg or lb).
     *
     * @param weight Weight to be checked.
     * @return True if weight is valid. Returns false otherwise.
     */
    private static boolean isValidWeight(String weight) {
        if (weight == null || weight.isEmpty()) {
            return false;
        }
        if (!weight.contains("kg") && !weight.contains("lb")) {
            return false;
        }
        try {
            Integer.parseUnsignedInt(weight.substring(0, max(weight.indexOf("kg"), weight.indexOf("lb"))));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //@@author calebcjl
    /**
     * Parses weight argument.
     *
     * @param weight Weight argument.
     * @return Weight.
     */
    private static String parseWeight(String weight) throws InvalidWeightException {
        weight = weight.trim();
        if (!isValidWeight(weight)) {
            throw new InvalidWeightException(MESSAGE_INVALID_WADD_COMMAND);
        }
        return weight;
    }


    //@@author calebcjl

    /**
     * Parses reps per set argument.
     *
     * @param repsPerSet Reps per set argument.
     * @return Reps per set.
     */
    private static String parseRepsPerSet(String repsPerSet) throws InvalidNumberForRepsException {
        repsPerSet = repsPerSet.trim();
        String[] reps = repsPerSet.split(" ");
        try {
            for (String repCount : reps) {
                Integer.parseUnsignedInt(repCount);
                //@@author ZIZI-czh
                if (reps.length > MAX_SETS_FOR_RPS) {
                    throw new ExceedMaxRpsSetsException(MESSAGE_EXCEED_MAX_SETS_FOR_RPS);
                }
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberForRepsException(INVALID_NUMBER_FOR_RPS);
        } catch (ExceedMaxRpsSetsException e) {
            throw new RuntimeException(e);
        }
        return repsPerSet;
    }

    //@@author ZIZI-czh

    /**
     * This method is used to check the "/start" command
     * Otherwise, StartCommand will be executed
     *
     * @param arguments Date input
     * @return Incorrect command if the input date is incorrect, otherwise, initialize the StartCommand
     */
    static Command parseStartWorkoutCommand(String arguments) throws InvalidArgumentException {
        Date date = new Date();
        String workoutName = parseWorkoutName(arguments);
        return new StartWorkoutCommand(date, workoutName);
    }

    //@@author calebcjl
    /**
     * Parses workout name for StartWorkoutCommand
     *
     * @param workoutName Name of workout.
     * @return Name of workout.
     * @throws InvalidArgumentException If workout name is invalid.
     */
    static String parseWorkoutName(String workoutName) throws InvalidArgumentException {
        try {
            //@@author ZIZI-czh
            HandleStringInput.isValidStringInput(workoutName);
        } catch (InputContainSpecialCharacter | LongInputException | MissingArgumentException |
                 InvalidSpaceNameException e) {
            throw new RuntimeException(e);
        }
        return workoutName.trim();
    }

    /**
     * This method is used to check the "/delete" command
     *
     * @param arguments Date input
     * @return DeleteWorkoutCommand.
     */
    static Command parseDeleteWorkoutCommand(String arguments) throws InvalidIndexException {
        arguments = arguments.trim();
        int index;
        try {
            index = Integer.parseUnsignedInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException(INVALID_INDEX);
        }
        return new DeleteWorkoutCommand(index);
    }

    //@@ author ZIZI-czh
    static Command parseListWorkoutCommand(String arguments) throws MultiArgumentDetectedException {
        if (arguments != null && !arguments.isBlank()) {
            throw new MultiArgumentDetectedException(MULTI_ARGUMENT);
        }
        return new ListWorkoutCommand();
    }


    //@@ author Richardtok
    static Command parseViewWorkoutCommand(String arguments) throws InvalidIndexException {
        arguments = arguments.trim();
        int index;
        try {
            index = Integer.parseUnsignedInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidIndexException(INVALID_INDEX);
        }
        return new ViewWorkoutCommand(index);
    }

    //@@ author guillaume-grn
    static Command parseSetsRepsCountCommand(String arguments) throws
             MultiSlashErrorException, InvalidDateFormatException, InvalidDayAndMonthException,
            InvalidYearException {
        Date date = parseDate(arguments);
        return new CountSetsRepsCommand(date);
    }

    //@@author calebcjl

    /**
     * Parses arguments of end workout command.
     *
     * @param arguments Arguments of end workout command.
     * @return End workout command.
     * @throws InvalidSyntaxException If syntax of command is invalid.
     */
    static Command parseEndWorkoutCommand(String arguments) throws  MultiArgumentDetectedException {
        if (arguments != null && !arguments.isBlank()) {
            throw new MultiArgumentDetectedException(MULTI_ARGUMENT);
        }
        return new EndWorkoutCommand();
    }
}
