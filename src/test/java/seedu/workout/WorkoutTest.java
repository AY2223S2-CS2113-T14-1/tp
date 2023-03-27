package seedu.workout;

import org.junit.jupiter.api.Test;
import seedu.workouttracker.workout.Workout;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void testGetDateAndSetDate() throws Exception {
        String expectedDatestring = "05/02/2023";
        Date expectedDate = dateFormat.parse(expectedDatestring);
        Workout workout = new Workout(expectedDate);
        assertEquals(expectedDate, workout.getDate());

        String newDatestring = "06/03/2024";
        Date newDate = dateFormat.parse(newDatestring);
        workout.setDate(newDate);
        assertEquals(newDate, workout.getDate());
    }


}
