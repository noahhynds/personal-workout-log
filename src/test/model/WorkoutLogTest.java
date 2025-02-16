package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.time.LocalDate;

public class WorkoutLogTest {
    WorkoutLog workOutLog;
    Workout w1;
    Workout w2;
    Workout w3;
    String exercise1;


    @BeforeEach
    void runBefore() {
        workOutLog = new WorkoutLog();
        w1 = new Workout("W1");
        w2 = new Workout("W2");
        w3 = new Workout("W3");
        exercise1 = "Bench Press";
        w1.addExercise(exercise1);
        w2.addExercise(exercise1);
        w3.addExercise(exercise1);

    }

    @Test
    void testWorkoutLogConstructor() {
        assertTrue(workOutLog.getWorkouts().isEmpty());
    }

    @Test
    void testAddWorkoutToLog() {
        assertEquals(Collections.emptyList(), workOutLog.getWorkouts());
        assertTrue(workOutLog.getWorkouts().isEmpty());
        workOutLog.addWorkoutToLog(w1);
        assertEquals(1, workOutLog.getWorkouts().size());
        workOutLog.addWorkoutToLog(w2);
        assertEquals(2, workOutLog.getWorkouts().size());
        workOutLog.addWorkoutToLog(w3);
        assertEquals(3, workOutLog.getWorkouts().size());

        assertEquals(w1, workOutLog.getWorkouts().get(0));
        assertEquals(w2, workOutLog.getWorkouts().get(1));
        assertEquals(w3, workOutLog.getWorkouts().get(2));

    }

}
