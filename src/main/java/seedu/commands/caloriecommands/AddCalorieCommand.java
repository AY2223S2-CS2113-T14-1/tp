package seedu.commands.caloriecommands;

import seedu.commands.Command;
import seedu.exceptions.InvalidSyntaxException;
import seedu.ui.Ui;

import java.util.Date;

//@@author calebcjl
/**
 * Represents command to add an entry to calorie tracker.
 */
public class AddCalorieCommand extends Command {
    public static final int CALORIES_NOT_GIVEN = -1;
    private final Date date;
    private final String foodName;
    private final int foodCalories;


    /**
     * Constructs an instance of AddCalorieCommand with the specified date, food name, and calorie intake.
     *
     * @param date the date of the food log
     * @param foodName the name of the food
     * @param foodCalories the calorie intake of the food
     */
    public AddCalorieCommand(Date date, String foodName, int foodCalories) {
        this.date = date;
        this.foodName = foodName;
        this.foodCalories = foodCalories;
    }


    /**
     * Constructs an instance of AddCalorieCommand with the specified date and food name, with the calorie intake
     * set to a default value of CALORIES_NOT_GIVEN.
     *
     * @param date the date of the food log
     * @param foodName the name of the food
     */
    public AddCalorieCommand(Date date, String foodName) {
        this.date = date;
        this.foodName = foodName;
        foodCalories = CALORIES_NOT_GIVEN;
    }

    @Override
    public String execute() throws InvalidSyntaxException {
        return Ui.showLineAfterEachCommand(calorieTracker.addCalories(date, foodName, foodCalories));
    }
}
