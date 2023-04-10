package seedu.commands.workoutcommands;

import seedu.commands.Command;
import seedu.exceptions.InvalidArgumentException;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;
import seedu.workout.WorkoutList;

import java.util.Date;

//@@ author ZIZI-czh
/**
 * Represents a command to delete a workout from the workout list, identified by the index of the workout to delete.
 * The index of the workout to delete is passed in through the constructor.
 */
public class DeleteWorkoutCommand extends Command {
    private final int workoutToDeleteIndex;

    //@@ author ZIZI-czh
    /**
     * Creates a new instance of DeleteWorkoutCommand with the specified index of the workout to delete.
     * @param workoutToDeleteIndex the index of the workout to delete
     */
    public DeleteWorkoutCommand(int workoutToDeleteIndex) {
        this.workoutToDeleteIndex = workoutToDeleteIndex;
    }

    //This one is for JUnit Test
    public DeleteWorkoutCommand(WorkoutList workoutListParameter, int workoutToDeleteIndex) {
        this.workoutToDeleteIndex = workoutToDeleteIndex;
        workoutList = workoutListParameter;
    }

    //@@author calebcjl
    @Override
    public String execute() throws InvalidArgumentException {
        if (workoutToDeleteIndex==-1 || workoutToDeleteIndex >= workoutList.getWorkouts().size()) {
            throw new InvalidArgumentException("index, indexes range from 1 to " + workoutList.getWorkouts().size());
        }

        String workoutName = workoutList.getWorkout(workoutToDeleteIndex).getWorkoutName();
        Date workoutDate = workoutList.getWorkout(workoutToDeleteIndex).getDate();
        workoutList.deleteWorkout(workoutToDeleteIndex);
        return Ui.showLineAfterEachCommand("Deleted " + workoutName + " on " +
                DateFormatter.dateToString(workoutDate) + '.');
    }
}


