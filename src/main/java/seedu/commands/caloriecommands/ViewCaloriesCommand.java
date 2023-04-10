package seedu.commands.caloriecommands;

import seedu.calorietracker.Food;
import seedu.commands.Command;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;

import java.util.Date;

//@@author Richardtok
public class ViewCaloriesCommand extends Command {
    private static final String HEADER = "Here are the foods consumed on ";
    private static final String FAIL_TO_FIND_DATE = " does not exit in the list";
    private final Date caloriesToViewDate;

    public ViewCaloriesCommand(Date caloriesToViewDate) {
        this.caloriesToViewDate = caloriesToViewDate;
    }


    @Override
    public String execute() {
        if (!calorieTracker.getDailyFoodConsumption().containsKey(caloriesToViewDate)) {
            return DateFormatter.dateToString(caloriesToViewDate) + FAIL_TO_FIND_DATE;
        }

        StringBuilder stringBuilder = new StringBuilder(HEADER + DateFormatter.dateToString(caloriesToViewDate)
                + ':' + System.lineSeparator());
        int counter = 1;
        for (Food food :calorieTracker.getDailyFoodConsumption().get(caloriesToViewDate).getFoods()) {
            stringBuilder.append(counter).append(". ").append(food.getFoodName()).append(" - ")
                    .append(food.getCalories()).append("kcal").append(System.lineSeparator());
            counter += 1;
        }
        return Ui.showLineAfterEachCommand(stringBuilder.append(Ui.line()).toString());
    }
}
