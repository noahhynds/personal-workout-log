package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.time.LocalDate;

public class WorkoutLogTest {
    WorkoutLog workoutLog;
    Workout w1;
    Workout w2;
    Workout w3;
    Workout w4;
    String exercise1;

    @BeforeEach
    void runBefore() {
        workoutLog = new WorkoutLog();
        w1 = new Workout("W1");
        w2 = new Workout("W2");
        w3 = new Workout("W3");
        w4 = new Workout("W4");
        exercise1 = "Bench Press";
        w1.addExercise(exercise1);
        w2.addExercise(exercise1);
        w3.addExercise(exercise1);

    }

    @Test
    void testWorkoutLogConstructor() {
        assertTrue(workoutLog.getWorkouts().isEmpty());
    }

    @Test
    void testAddWorkoutToLog() {
        assertEquals(Collections.emptyList(), workoutLog.getWorkouts());
        assertTrue(workoutLog.getWorkouts().isEmpty());
        workoutLog.addWorkoutToLog(w1);
        assertEquals(1, workoutLog.getWorkouts().size());
        workoutLog.addWorkoutToLog(w2);
        assertEquals(2, workoutLog.getWorkouts().size());
        workoutLog.addWorkoutToLog(w3);
        assertEquals(3, workoutLog.getWorkouts().size());

        assertEquals(w1, workoutLog.getWorkouts().get(0));
        assertEquals(w2, workoutLog.getWorkouts().get(1));
        assertEquals(w3, workoutLog.getWorkouts().get(2));

        assertFalse(workoutLog.addWorkoutToLog(null));
        assertFalse(workoutLog.addWorkoutToLog(w4));
        assertFalse(workoutLog.addWorkoutToLog(w1));

    }
}
