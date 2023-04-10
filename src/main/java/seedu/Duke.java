package seedu;

import seedu.calorietracker.CalorieTracker;
import seedu.calorietracker.FoodDictionary;
import seedu.commands.Command;
import seedu.commands.ExitCommand;
import seedu.parser.Parser;
import seedu.storage.Storage;
import seedu.ui.Ui;
import seedu.workout.WorkoutList;

//@@author calebcjl
/**
 * Main entry to the program
 */
public class Duke {
    private WorkoutList workoutList;
    private CalorieTracker calorieTracker;
    private FoodDictionary foodDictionary;
    private Storage storage;

    public Duke() {
    }

    public static void main(String[] args) {
        new Duke().run();
    }

    //@@author calebcjl
    /**
     * Runs the program.
     */
    private void run() {
        storage = new Storage();
        workoutList = new WorkoutList(storage);
        foodDictionary = new FoodDictionary(storage);
        calorieTracker = new CalorieTracker(storage, foodDictionary);
        Ui.showWelcomeMessage();
        executeCommandUntilExit();
    }

    //@@author calebcjl
    /**
     * Continuously receives and execute commands entered by user.
     * Stops when user enters exit command.
     */
    private void executeCommandUntilExit() {
        Command command;
        do {
            String userInput = Ui.getUserInput();
            try {
                command = Parser.parseCommand(userInput);
                command.setData(workoutList, calorieTracker, foodDictionary);
                Ui.showCommandResult(command);
            } catch(Exception e) {
                // remove package name
                String errorMessage = e.getMessage().replaceAll(".*\\.(.*)Exception: ", "");
                Ui.printErrorMessage(errorMessage);
                command = new Command();
            }
            storage.saveUserData(workoutList, foodDictionary, calorieTracker);
        } while (!ExitCommand.isExit(command));
    }
}

