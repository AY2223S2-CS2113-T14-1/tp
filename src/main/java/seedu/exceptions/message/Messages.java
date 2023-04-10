package seedu.exceptions.message;

public class Messages {

    // Parser Class
    public static final String MESSAGE_COMMAND_UNRECOGNIZABLE =
            "This command is unrecognizable!!!\n" + "Please use the '/whelp' or '/chelp' command to check";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "Invalid date format!\n"
            + "Please follow the format dd/MM/yy.";
    public static final String MESSAGE_CONTAIN_MULTI_SLASH = "Your input date contains multi-slash!\n"
            + "Please follow the format dd/MM/yy.";
    public static final String MESSAGE_INCORRECT_DAY_OR_MONTH = "Your input for either day or month is wrong.\n"
            + "Please enter the day between 1 and 30.\n"
            + "Please enter the month between 1 and 12.";
    public static final String MESSAGE_INCORRECT_YEAR = "Your input for year is incorrect.\n"
            + "Please use 2 or 4 digit year between 0 and 2023";

    //HandleStringInput Class
    public static final String MESSAGE_LONG_INPUT = "Your input is too long!\n"
            + "Your input should not exceed 4 words or 20 characters for each word.";
    public static final String MESSAGE_CONTAIN_SPECIAL_CHARACTER = "Invalid name! Only number, " +
            "letter and spaced are allowed!";
    public static final String MESSAGE_EXCEED_MAX_SETS_FOR_RPS = "The max sets for rps is 15!";

    public static final String MESSAGE_MISSING_ARGUMENT = "The command is incomplete. Missing arguments!";

    public static final String MESSAGE_INVALID_SPACE_NAME = "Name contains only space is not allowed."
        + "Please enter a valid name!";

    public static final String MESSAGE_INVALID_WADD_COMMAND = "In correct syntax for 'wadd' command, " +
            "please check user guide.";

    public static final String INVALID_NUMBER_FOR_RPS = "Please enter a valid number for reps!";
    public static final String INVALID_INDEX = "Please enter a index number!";
    public static final String MULTI_ARGUMENT = "Unexpected Argument detected";
    public static final String INVALID_INPUT_GUIDE = "Invalid input command, please refer to User guide.";
    public static final String INVALID_CALORIES_INPUT = "Please enter a valid calorie value";


}
