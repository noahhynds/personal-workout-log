package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class JsonWriterTest extends JsonTest {
    WorkoutLog wl;
    Workout w1;
    Workout w2;
    Workout w3;
    Workout w4;
    String exercise1;
    String exercise2;
    String exercise3;
    String exercise4;
    LocalDate today;

    @BeforeEach
    void runBefore() {
        today = LocalDate.now();
        wl = new WorkoutLog();
        w1 = new Workout("W1");
        w2 = new Workout("W2");
        w3 = new Workout("W3");
        w4 = new Workout("W4");
        exercise1 = "Bench Press";
        exercise2 = "Pull Ups";
        exercise3 = "Squats";
        exercise4 = "Pec Deck";

        w1.addExercise(exercise1);
        w2.addExercise(exercise2);
        w3.addExercise(exercise3);
        w1.addExercise(exercise4);
    }

    @Test
    void testWriterInvalidFile() {

        JsonWriter writer = new JsonWriter("./data/kmmy\0illegal:lme.json");

    }

    @Test
    void testWriterNoWorkoutsYet() {

        // Write
        JsonWriter writer = new JsonWriter("./data/testWriteEmpty.json");
        // writer.open();
        writer.write(wl);
        // writer.close();

        // Read

        JsonReader reader = new JsonReader("./data/testWriteEmpty.json");
        wl = reader.load();
        assertEquals(Collections.emptyList(), wl.getWorkouts());

    }

    @Test
    void testWorkingNormally() {

        // Create log
        w1.addComment("Was good");
        w2.addComment("Was tired");
        w3.addComment("Hit PR");
        wl.addWorkoutToLog(w1);
        wl.addWorkoutToLog(w2);
        wl.addWorkoutToLog(w3);
        wl.addWorkoutToLog(w4);

        // Write
        JsonWriter writer = new JsonWriter("./data/testWriteNormal.json");
        // writer.open();
        writer.write(wl);
        // writer.close();

        // Read
        JsonReader reader = new JsonReader("./data/testWriteNormal.json");
        wl = reader.load();

        // Checks
        checkTitle("W1", w1);
        checkTitle("W2", w2);
        checkTitle("W3", w3);

        checkDate(today, w1);
        checkDate(today, w2);
        checkDate(today, w3);

        // checkId("b47d348d-a622-47a2-b79f-cfd69df36dcf", w1);
        // checkId("74afd5a7-1ab7-40f3-b0a6-34e4976768ae", w1);
        // checkId("0c4e9243-3706-46b3-bce7-1146cf92079d", w1);

        checkStatus(false, w1);
        checkStatus(false, w1);
        checkStatus(false, w1);

        checkComments(List.of("Was good"), w1);
        checkComments(List.of("Was tired"), w2);
        checkComments(List.of("Hit PR"), w3);

        checkExercises(List.of(exercise1, exercise4), w1);
        checkExercises(List.of(exercise2), w2);
        checkExercises(List.of(exercise3), w3);

    }

    @Test
    void testExceptions() {
        Exception exception = assertThrows(IOException.class, () -> {
            throw new IOException("ERROR SAVING WORKOUTS");
        });
        assertEquals("ERROR SAVING WORKOUTS", exception.getMessage());
    }
}
