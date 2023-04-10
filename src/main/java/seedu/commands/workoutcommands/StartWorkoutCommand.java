package seedu.commands.workoutcommands;

import seedu.commands.Command;
import seedu.exceptions.InvalidArgumentException;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;

import java.util.Date;

import static seedu.workout.WorkoutList.NO_CURRENT_WORKOUT;

//@@author calebcjl
/**
 * Represents command to start a new workout on the current date.
 */
public class StartWorkoutCommand extends Command {
    private static final String ONGOING_WORKOUT_MESSAGE = "There is already an ongoing workout!";
    private final String workoutName;
    private final Date date;


    /**
     * Represents a command to start a new workout with the specified date and workout name.
     *
     * @param date the date of the new workout
     * @param workoutName the name of the new workout
     */
    public StartWorkoutCommand(Date date, String workoutName) {
        this.date = date;
        this.workoutName = workoutName;
    }

    /**
     * Executes the command to start a new workout.
     * Only start a new workout if there is no current workout ongoing.
     * It will not start the workout if there already exists a workout with the same name and date.
     *
     * @return Workout start message if workout is started. Returns ongoing workout message.
     * @throws InvalidArgumentException If name and date of workout to be added is the same as a workout that
     *     is already in the workout list.
     */
    @Override
    public String execute() throws InvalidArgumentException {
        if (workoutList.getCurrentWorkoutIndex() != NO_CURRENT_WORKOUT) {
            return ONGOING_WORKOUT_MESSAGE;
        }
        workoutList.startWorkout(date, workoutName);
        return Ui.showLineAfterEachCommand(workoutName + " started on " + DateFormatter.dateToString(date) + '.');
    }
}
