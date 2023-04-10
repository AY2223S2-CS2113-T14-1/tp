package seedu.commands.workoutcommands;

import seedu.commands.Command;
import seedu.ui.Ui;

import java.util.Date;

//@@author guillaume-grn
public class CountSetsRepsCommand extends Command {
    private final Date dayInSpecificWeekDate;


    public CountSetsRepsCommand(Date dayInSpecificWeekDate) {
        this.dayInSpecificWeekDate = dayInSpecificWeekDate;
    }

    @Override
    public String execute() {
        return Ui.showLineAfterEachCommand(workoutList.countSetsReps(dayInSpecificWeekDate));
    }
}
