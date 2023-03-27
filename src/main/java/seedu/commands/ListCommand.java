package seedu.commands;


import seedu.ui.Ui;
import seedu.workout.Workout;

/**
 * This is the class for executing the list command
 */
public class ListCommand extends Command {

    //@@ author ZIZI-czh
    public ListCommand() {

    }

    /**
     * Show the list of date of the workout by calling the method in workoutList
     */
    //@@ author ZIZI-czh
    @Override
    public void execute() {
        try {
            if (!workoutList.workoutArrayList.isEmpty()) {
                System.out.println("Here are the list of dates for your workout: ");
                for (Workout workout : workoutList.workoutArrayList) {
                    System.out.println(workout.getDate());
                }
                Ui.showSeperator();
            } else {
                //if there is no workout have been done
                System.out.println("Haven't start your workout, please enter your workout");
            }

        } catch (NullPointerException e) {
            System.out.println("Haven't start your workout, please enter your workout");
        }

    }
}

