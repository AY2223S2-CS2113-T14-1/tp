package seedu.ui;

import seedu.commands.Command;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.InvalidSyntaxException;

import java.util.Scanner;

public class Ui {
    private static final String LINE = "=======================================";
    private static final String LINE_SEPARATOR = "----------------------------------------";

    private static final String WELCOME_MESSAGE = "Welcome to FITZ! Time to record your " +
            "daily workouts and calories consumption!\n"
            + "Enter \"/whelp\" "
            + "if you need the list of commands for workouts record.\n"
            + "Enter \"/chelp\" "
            + "if you need the list of commands for calories record.\n"
            + LINE_SEPARATOR;
    private static final String LOGO_MESSAGE = " _______  __  .___________.________  \n" +
            "|   ____||  | |           |       /  \n" +
            "|  |__   |  | `---|  |----`---/  /   \n" +
            "|   __|  |  |     |  |       /  /    \n" +
            "|  |     |  |     |  |      /  /----.\n" +
            "|__|     |__|     |__|     /________|";
    private static final Scanner in = new Scanner(System.in);
    //@@ author RIchardtok
    private static final String HELP_MESSAGE_WORKOUT =
            "Here are the list of commands that you can use for workout record:"
                    +System.lineSeparator() + LINE + System.lineSeparator()
                    + "- [Start a workout: /wstart EXERCISE_NAME])" + System.lineSeparator()
                    + "- [Add exercise: /wadd EXERCISE_NAME WEIGHT_USED_WEIGHT_UNIT RPS]" + System.lineSeparator()
                    + "- [Start a workout: /wstart])" + System.lineSeparator()
                    + "- [Add exercise: /wadd]" + System.lineSeparator()
                    + "- [Display all the days: /wlist]" + System.lineSeparator()
                    + "- [Display workouts information for a specific day: /wview INDEX]" + System.lineSeparator()
                    + "- [Display total amount of reps and set for one week /wcount DD/MM/YY]" + System.lineSeparator()
                    + "- [Delete workouts: /wdelete INDEX]" + System.lineSeparator()
                    + "- [End current workout: /wend]" + System.lineSeparator() + LINE
                    + "- [Exit app: /exit]" + System.lineSeparator() + LINE;
    private static final String HELP_MESSAGE_CALORIES =
            "Here are the list of commands that you can use for calories record:"
                    +System.lineSeparator() + LINE + System.lineSeparator()
                    + "- [Add food and calories: /cadd DD/MM/YY]" + System.lineSeparator()
                    + "- [Display total calories consumption: /clist]" + System.lineSeparator()
                    + "- [Display calories consumed on a specific date : /cview DD/MM/YY]" + System.lineSeparator()
                    + "- [Delete calories record for one food: /cdelete DD/MM/YY]"
                    + System.lineSeparator() + LINE + System.lineSeparator();
    private static final String READ_FILE_ERROR_MESSAGE = "Error reading file: ";
    public static void showGreeting() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void showLogo(){
        System.out.println(LOGO_MESSAGE);
    }

    public static void showOneLine(){
        System.out.println(LINE);
    }


    public static String line() {
        return LINE;
    }

    public static String getUserInput() {
        return in.nextLine();
    }

    public static void showWelcomeMessage() {
        showOneLine();
        showLogo();
        showOneLine();
        showGreeting();
    }

    public static String getWorkoutHelpMessage() {
        return HELP_MESSAGE_WORKOUT;
    }

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showCommandResult(Command command)
            throws InvalidArgumentException, InvalidSyntaxException {
        System.out.println(command.execute());
    }

    public static void showReadFileErrorMessage(String fileName) {
        System.out.println(READ_FILE_ERROR_MESSAGE + fileName);
    }

    public static void showNoSavedDataMessage(String fileName) {
        System.out.println("No saved data found for " + fileName + '.');
        System.out.println("Creating new file for " + fileName + ".......");
    }

    public static void showCreatedNewFileMessage(String fileName) {
        System.out.println("New file for " + fileName + " created.");
    }
    public static void showNewFileNotCreatedMessage(String fileName) {
        System.out.println("Error creating new file for " + fileName + ".");
        System.out.println("User data may not be saved!");
    }

    public static void showCreateDirectoryMessage() {
        System.out.println("Creating directories.....");
    }

    public static void showDirectoryNotCreatedMessage() {
        System.out.println("Unable to create directories. User data may not be saved.");
    }

    public static void showSaveUserDataErrorMessage() {
        System.out.println("Error saving user data.");
    }
    public static void showSuccessfulLoadDataMessage(String fileName) {
        System.out.println("Successfully loaded " + fileName + " data.");
    }

    public static String getCaloriesHelpMessage() {
        return HELP_MESSAGE_CALORIES;
    }


    public static void showLine(){
        System.out.println(LINE);
    }
    public static void printErrorMessage(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public static String showLineAfterEachCommand(String message){
        return LINE + System.lineSeparator() + message + System.lineSeparator() + LINE;
    }

}
