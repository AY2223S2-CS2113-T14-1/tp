package seedu.commands.workoutcommands;

//@@ author ZIZI-czh
import seedu.commands.Command;
import seedu.parser.DateFormatter;
import seedu.ui.Ui;
import seedu.workout.Workout;
import seedu.workout.WorkoutList;

/**
 * This is the class for executing the list command
 */
public class ListWorkoutCommand extends Command {

    private static final String EMPTY_LIST_MESSAGE = "Workout list is empty";
    private static final String WORKOUT_LIST_HEADER =
            "Here is the list of dates of your workouts:" + System.lineSeparator();

    //@@ author ZIZI-czh
    public ListWorkoutCommand() {
    }

    public ListWorkoutCommand(WorkoutList workoutListParameter) {
        workoutList = workoutListParameter;
    }

    //@@author ZIZI-czh
    /**
     * Executes the command to display a list of all the workouts in the workout list.
     * If the workout list is empty, returns a message indicating that the list is empty.
     * @return a string representation of the list of workouts, including their respective dates and names
     */
    @Override
    public String execute() {

        if (workoutList.isEmptyList()) {
            return EMPTY_LIST_MESSAGE;
        }

        StringBuilder listOfWorkouts = new StringBuilder(WORKOUT_LIST_HEADER);
        int counter = 1;
        for (Workout workout : workoutList.getWorkouts()) {
            String listNumber = counter + ". ";
            String date = DateFormatter.dateToString(workout.getDate()) + ' ';
            String workoutName = workout.getWorkoutName();
            listOfWorkouts.append(listNumber).append(date).append(workoutName).append(System.lineSeparator());
            counter += 1;
        }
        return Ui.showLineAfterEachCommand(listOfWorkouts.append(Ui.line()).toString());
    }
}


