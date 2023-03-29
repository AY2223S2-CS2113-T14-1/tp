package seedu.commands.workoutcommands;

import seedu.DateFormat;
import seedu.commands.Command;

import seedu.ui.Ui;
import seedu.workout.Workout;

import java.util.Date;

public class ViewWorkoutCommand extends Command {
    Date workoutToViewDate;

    public ViewWorkoutCommand(Date workoutToViewDate) {
        this.workoutToViewDate = workoutToViewDate;
    }

    public void execute() {

        for (Workout workout : workoutList.workoutArrayList) {
            DateFormat dateFormat = new DateFormat(workoutToViewDate);
            String formattedDate = dateFormat.formatDate();
            if (workout.getStringDate().equals(formattedDate)) {
                System.out.println(workout.getExercises());
                Ui.showSeparator();
                return;
            }
        }

    }
}
