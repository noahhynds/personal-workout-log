package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import javax.imageio.IIOException;

public class JsonReaderTest extends JsonTest {
    WorkoutLog workoutlog;

    LocalDate today;

    @BeforeEach
    void runBefore() {
        today = LocalDate.now();
        workoutlog = new WorkoutLog();
    }

    @Test
    void testFileDoesNotExist() {

        JsonReader reader = new JsonReader("./data/testFileNoExist.json");
        workoutlog = reader.load();

    }

    @Test
    void testReadEmpty() {

        JsonReader reader = new JsonReader("./data/testReadEmpty.json");
        workoutlog = reader.load();
        assertEquals(Collections.emptyList(), workoutlog.getWorkouts());

    }

    @Test
    void testReadNormal() {

        JsonReader reader = new JsonReader("./data/testReadNormal.json");
        workoutlog = reader.load();

        List<Workout> workouts = workoutlog.getWorkouts();

        checkTitle("W1", workouts.get(0));
        checkTitle("W2", workouts.get(1));
        checkTitle("W3", workouts.get(2));

        checkId("13412ae0-4123-4cb5-bf39-c7efc85830f6", workouts.get(0));
        checkId("68edab52-1a6a-4293-9785-2a84bc1c35ce", workouts.get(1));
        checkId("9b3e464a-462b-428c-9d58-f3aea0c1f445", workouts.get(2));

        assertEquals("2025-03-01", workouts.get(0).getDate().toString());
        assertEquals("2025-02-25", workouts.get(1).getDate().toString());
        assertEquals("2025-02-20", workouts.get(2).getDate().toString());

        checkStatus(true, workouts.get(0));
        checkStatus(false, workouts.get(1));
        checkStatus(true, workouts.get(2));

        checkComments(List.of("Was good", "Was strong"), workouts.get(0));
        checkComments(List.of("Was tired"), workouts.get(1));
        checkComments(List.of("Hit PR"), workouts.get(2));

        checkExercises(List.of("Bench Press", "Pec Deck"), workouts.get(0));
        checkExercises(List.of("Pull Ups", "Bicep curls"), workouts.get(1));
        checkExercises(List.of("Squats", "Leg press"), workouts.get(2));

    }

    @Test
    void testExceptions() {
        Exception exception = assertThrows(IOException.class, () -> {
            throw new IOException("ERROR LOADING FILE");
        });

        assertEquals("ERROR LOADING FILE", exception.getMessage());
    }

}
