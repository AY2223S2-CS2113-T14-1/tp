package seedu.commands.workoutcommands;

import seedu.commands.Command;
import seedu.ui.Ui;
import seedu.workout.Exercise;
import seedu.workout.Workout;

import static seedu.workout.WorkoutList.NO_CURRENT_WORKOUT;

//@@author calebcjl
/**
 * Represents command to add an exercise to the current workout.
 */
public class AddExerciseCommand extends Command {
    private static final String EXERCISE_ADDED_MESSAGE = " has been added.";
    private static final String NO_CURRENT_WORKOUT_MESSAGE = "Start a workout before adding exercises!";
    private final Exercise exerciseToAdd;

    public AddExerciseCommand(Exercise exerciseToAdd) {
        this.exerciseToAdd = exerciseToAdd;
    }

    /**
     * Executes the command to add the exercise to the current workout.
     * If there is no current workout ongoing, exercise will not be added.
     *
     * @return Exercise added message if successful. Returns no current workout message otherwise.
     */
    @Override
    public String execute() {
        if (workoutList.getCurrentWorkoutIndex() == NO_CURRENT_WORKOUT) {
            return NO_CURRENT_WORKOUT_MESSAGE;
        }
        Workout currentWorkout = workoutList.getCurrentWorkout();
        currentWorkout.addExercise(exerciseToAdd);
        return Ui.showLineAfterEachCommand(exerciseToAdd + EXERCISE_ADDED_MESSAGE);
    }
}
