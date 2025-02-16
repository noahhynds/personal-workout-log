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

    @BeforeEach
    void runBefore() {
        workOutLog = new WorkoutLog();
        w1 = new Workout("W1");
        w2 = new Workout("W2");
        w3 = new Workout("W3");

    }

    @Test
    void testWorkoutLogConstructor() {
        assertTrue(workOutLog.getWorkoutLog().isEmpty());
    }

    @Test
    void testAddWorkoutToLog() {
        assertTrue(workOutLog.getWorkoutLog().isEmpty());
        workOutLog.addWorkoutToLog(w1);
        assertEquals(1, workOutLog.getWorkoutLog().size());
        workOutLog.addWorkoutToLog(w2);
        assertEquals(2, workOutLog.getWorkoutLog().size());
        workOutLog.addWorkoutToLog(w3);
        assertEquals(3, workOutLog.getWorkoutLog().size());

        assertEquals(w1, workOutLog.getWorkoutLog().get(0));
        assertEquals(w2, workOutLog.getWorkoutLog().get(1));
        assertEquals(w3, workOutLog.getWorkoutLog().get(2));

    }

}
