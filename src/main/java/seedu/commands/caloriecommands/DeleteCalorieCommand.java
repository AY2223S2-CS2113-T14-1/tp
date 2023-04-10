package seedu.commands.caloriecommands;

import seedu.calorietracker.Food;
import seedu.commands.Command;
import seedu.exceptions.InvalidArgumentException;
import seedu.exceptions.InvalidSyntaxException;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;

import java.util.Date;

//@@author calebcjl
/**
 * Represents command to delete calorie consumption entry.
 */
public class DeleteCalorieCommand extends Command {
    public static final int NO_INDEX = -1;
    private Date date;
    private int index;
    public DeleteCalorieCommand(Date date) {
        this.date = date;
        index = NO_INDEX;
    }

    public DeleteCalorieCommand(Date date, int index) {
        this.date = date;
        this.index = index;
    }

    @Override
    public String execute() throws InvalidArgumentException, InvalidSyntaxException {
        if (index == NO_INDEX) {
            calorieTracker.getDailyFoodConsumption().remove(date);
            return "Deleted calorie consumption on " + DateFormatter.dateToString(date) + '.';
        }
        Food deletedFood = calorieTracker.getDailyFoodConsumption().get(date).getFood(index);
        calorieTracker.getDailyFoodConsumption().get(date).deleteFood(index);
        return Ui.showLineAfterEachCommand("Deleted " + deletedFood.getFoodName()
                + "(" + deletedFood.getCalories() + " kcal) from "
                + DateFormatter.dateToString(date));
    }
}
