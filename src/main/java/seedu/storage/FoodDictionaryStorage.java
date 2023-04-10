package seedu.storage;


//@@ author ZIZI-czh
import seedu.ui.Ui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//@@author ZIZI-czh

/**
 * Represents a storage for FoodDictionary.
 */
public class FoodDictionaryStorage {
    private static final File defaultFoodDictionaryFile = new File("data/fooddict.txt");
    private final File foodDictionaryFile;

    public FoodDictionaryStorage() {
        foodDictionaryFile = defaultFoodDictionaryFile;
    }


    //@@author ZIZI-czh

    /**
     * Retrieves the saved user food dictionary data from a file and returns it as a HashMap.
     * If the file exists, reads the file line by line and adds the key-value pairs to the HashMap.
     * If the file does not exist, creates a new file and displays a message to the user.
     * If an error occurs while reading the file, displays an error message to the user.
     * After retrieving the data, displays a success message to the user.
     *
     * @return A HashMap representing the saved user food dictionary data.
     */
    public HashMap<String, Integer> getUserData() {
        HashMap<String, Integer> savedFoodDictionary = new HashMap<>();
        if (foodDictionaryFile.exists()) {
            try {
                Scanner scanner = new Scanner(foodDictionaryFile);
                while (scanner.hasNext()) {
                    readFoodDictionaryFileLine(scanner.nextLine(), savedFoodDictionary);
                }
            } catch (FileNotFoundException e) {
                Ui.showReadFileErrorMessage("food dictionary");
            }
        } else {
            Ui.showNoSavedDataMessage("food dictionary");
            createFoodDictionaryFile();
        }
        Ui.showSuccessfulLoadDataMessage("food dictionary");
        Ui.showOneLine();
        return savedFoodDictionary;
    }

    //@@author ZIZI-czh

    /**
     * Reads a single line from the food dictionary file and extracts the name and calorie count of a food item.
     * The extracted data is added to the provided hashmap of saved food items.
     *
     * @param line                the line to read and extract data from
     * @param savedFoodDictionary the hashmap to add the extracted food item data to
     */
    private void readFoodDictionaryFileLine(String line, HashMap<String, Integer> savedFoodDictionary) {
        String[] data = line.split(":");
        savedFoodDictionary.put(data[0], Integer.valueOf(data[1]));
    }

    //@@author ZIZI-czh

    /**
     * Creates a new file for the food dictionary if it doesn't exist.
     * If the file already exists, does nothing.
     * If the creation is successful, displays a success message to the user.
     * If the creation fails, displays an error message to the user.
     */
    private void createFoodDictionaryFile() {
        try {
            if (foodDictionaryFile.createNewFile()) {
                Ui.showCreatedNewFileMessage("food dictionary");
            }
        } catch (IOException e) {
            Ui.showNewFileNotCreatedMessage("food dictionary");
        }
    }

    //@@author ZIZI-czh

    /**
     * Saves the given HashMap of food names and calorie counts to the food dictionary file. Each line of the file
     * contains a food name followed by a colon and the corresponding calorie count. The file is created if it doesn't
     * exist. If the file already exists, it is overwritten with the new data.
     *
     * @param foodCalories a HashMap that maps food names to their respective calorie counts
     * @throws IOException if there is an error writing to the file
     */
    public void saveUserData(HashMap<String, Integer> foodCalories) throws IOException {
        FileWriter fileWriter = new FileWriter(foodDictionaryFile);
        for (String foodName : foodCalories.keySet()) {
            fileWriter.write(foodName + ':' + foodCalories.get(foodName) + System.lineSeparator());
        }
        fileWriter.close();
    }
}
