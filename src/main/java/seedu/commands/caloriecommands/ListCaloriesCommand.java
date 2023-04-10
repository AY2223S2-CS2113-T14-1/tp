package seedu.commands.caloriecommands;

import seedu.calorietracker.FoodList;
import seedu.commands.Command;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;

import java.util.Date;
import java.util.TreeMap;

//@@author calebcjl
/**
 * Represents list calories command.
 */
public class ListCaloriesCommand extends Command {
    private static final String EMPTY_LIST_MESSAGE = "Calorie consumption list is empty!";
    private static final String HEADER =
            "Here is your list of daily calorie consumption: " + System.lineSeparator();
    public ListCaloriesCommand() {
    }

    @Override
    public String execute() {
        if (calorieTracker.getDailyFoodConsumption().isEmpty()) {
            return EMPTY_LIST_MESSAGE;
        }

        TreeMap<Date, FoodList> sortedMap = new TreeMap<>(calorieTracker.getDailyFoodConsumption());
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        int counter = 1;
        for (Date date: sortedMap.keySet()) {
            stringBuilder.append(counter).append(". ").append(DateFormatter.dateToString(date)).append(": ")
                    .append(sortedMap.get(date).getTotalCalories()).append("kcal").append(System.lineSeparator());
            counter += 1;
        }
        return Ui.showLineAfterEachCommand(stringBuilder.append(Ui.line()).toString());
    }
}
