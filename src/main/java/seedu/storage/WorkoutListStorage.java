package seedu.storage;

//@@ author ZIZI-czh
import seedu.parser.DateFormatter;
import seedu.ui.Ui;
import seedu.workout.Exercise;
import seedu.workout.Workout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Represents a storage for WorkoutList.
 */
public class WorkoutListStorage {
    private static final File defaultWorkoutListFile = new File("data/workoutlist.txt");
    private final File workoutListFile;



    public WorkoutListStorage() {
        workoutListFile = defaultWorkoutListFile;
    }


    //@@author ZIZI-czh
    /**
     * Retrieves the saved workout data from the workout list file and returns an ArrayList of Workout objects.
     * If the workout list file does not exist, the method shows a message to the user and creates the file.
     * If there is an error reading the file, the method shows an error message to the user.
     * The method also shows a successful message to the user indicating that the workout data has been loaded.
     *
     * @return An ArrayList of Workout objects containing the saved workout data.
     */
    public ArrayList<Workout> getUserData() {
        ArrayList<Workout> savedWorkoutList = new ArrayList<>();
        if (workoutListFile.exists()) {
            try {
                Scanner scanner = new Scanner(workoutListFile);
                while (scanner.hasNext()) {
                    readWorkoutListFileLine(scanner.nextLine(), savedWorkoutList);
                }
            } catch (FileNotFoundException | ParseException e) {
                Ui.showReadFileErrorMessage("workout list file");
            }
        } else {
            Ui.showNoSavedDataMessage("workout list");
            createWorkoutListFile();
        }
        Ui.showSuccessfulLoadDataMessage("workout list");
        Ui.showOneLine();
        return savedWorkoutList;
    }

    //@@author ZIZI-czh
    /**
     * Reads a single line from the workout list file and creates a Workout object from the data.
     * The Workout object is then added to the given ArrayList of Workout objects.
     *
     * @param line              A String representing a single line of data from the workout list file.
     * @param savedWorkoutList  An ArrayList of Workout objects where the resulting Workout object will be added.
     * @throws ParseException   If there is an error parsing the date from the line of data.
     */
    private void readWorkoutListFileLine(String line, ArrayList<Workout> savedWorkoutList) throws ParseException {
        String[] data = line.split(",");
        Workout workout = new Workout(DateFormatter.stringToDate(data[0]), data[1]);
        for (int i = 2; i < data.length - 2; i += 3) {
            Exercise exercise = new Exercise(data[i], data[i + 1], data[i + 2]);
            workout.addExercise(exercise);
        }
        savedWorkoutList.add(workout);
    }


    //@@author ZIZI-czh
    /**
     * Creates a new workout list file and displays appropriate messages to the user based on
     * whether the directory and file were created successfully or not.
     * If the directory was created successfully, a success message is displayed to the user.
     * If the directory was not created successfully, an error message is displayed to the user.
     * If the file was created successfully, a success message is displayed to the user.
     * If the file was not created successfully, an error message is displayed to the user.
     */
    private void createWorkoutListFile() {
        try {
            if (workoutListFile.getParentFile().mkdirs()) {
                Ui.showCreateDirectoryMessage();
            } else {
                Ui.showDirectoryNotCreatedMessage();
            }
            if (workoutListFile.createNewFile()) {
                Ui.showCreatedNewFileMessage("workout list");
            }
        } catch (IOException e) {
            Ui.showNewFileNotCreatedMessage("workout list");
        }
    }


    //@@author ZIZI-czh
    /**
     * Saves the list of workouts to the workout list file.
     *
     * @param workouts the list of workouts to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveUserData(ArrayList<Workout> workouts) throws IOException {
        FileWriter fileWriter = new FileWriter(workoutListFile);
        for (Workout workout : workouts) {
            fileWriter.write(DateFormatter.dateToString(workout.getDate()) + ','
                    + workout.getWorkoutName() + ',');
            for (Exercise exercise : workout.getExercises()) {
                fileWriter.write(exercise.getName() + ',' + exercise.getWeight() + ','
                        + exercise.getRepsPerSet() + ',');
            }
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();
    }
}
