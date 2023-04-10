package seedu.commands.workoutcommands;

import seedu.commands.Command;

import static seedu.ui.Ui.showLineAfterEachCommand;
import static seedu.workout.WorkoutList.NO_CURRENT_WORKOUT;

//@@author calebcjl
/**
 * Represents command to end the current workout.
 */
public class EndWorkoutCommand extends Command {
    private static final String NO_CURRENT_WORKOUT_MESSAGE = "No ongoing workout to end!";
    private static final String WORKOUT_COMPLETE_MESSAGE = "Great job completing your workout!";

    public EndWorkoutCommand() {
    }

    /**
     * Ends the current workout.
     * If there is no current workout ongoing, no workout will be ended.
     *
     * @return Returns workout completed message if current workout is ended.
     *
     */
    @Override
    public String execute() {
        if (workoutList.getCurrentWorkoutIndex() == NO_CURRENT_WORKOUT) {
            return NO_CURRENT_WORKOUT_MESSAGE;
        }
        workoutList.setCurrentWorkoutIndex(NO_CURRENT_WORKOUT);

        return showLineAfterEachCommand(WORKOUT_COMPLETE_MESSAGE);

    }
}
