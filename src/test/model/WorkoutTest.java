package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.time.LocalDate;

public class WorkoutTest {
    Workout workout;
    LocalDate today;

    @BeforeEach
    void runBefore() {
        workout = new Workout("Push 1");
        today = LocalDate.now();

    }

    @Test
    void testWorkoutConstructor() {
        assertEquals(today, workout.getDate());
        assertEquals("Push 1", workout.getTitle());
        assertTrue(workout.exercises.isEmpty());

    }

    @Test
    void testAddExercise() {
        workout.addExercise("Push Up");
        assertEquals(1, workout.exercises.size());
        assertTrue(workout.addExercise("Bench Press"));
        assertEquals(2, workout.exercises.size());
        assertFalse(workout.addExercise("Bench Press"));

        assertFalse(workout.addExercise(null));
        assertFalse(workout.addExercise(""));
        

    }

    @Test
    void testGetAllExercises() {

        assertEquals(0, workout.getAllExercises().size());
        assertEquals(Collections.emptyList(), workout.getAllExercises());

        workout.addExercise("Push Up");
        workout.addExercise("Bench Press");
        workout.addExercise("Pull Up");

        
        assertEquals(3, workout.getAllExercises().size());
        assertEquals("Push Up", workout.getAllExercises().get(0));
        assertEquals("Bench Press", workout.getAllExercises().get(1));
        assertEquals("Pull Up", workout.getAllExercises().get(2));

    }

    @Test
    void testMarkWorkoutAsComplete() {
        assertFalse(workout.getStatusOfWorkout());
        workout.markWorkoutAsComplete();
        assertTrue(workout.getStatusOfWorkout());
        workout.markWorkoutAsComplete();
        assertTrue(workout.getStatusOfWorkout());
    }

    @Test
    void testAddComment() {
        workout.addComment("Comment 1");
        assertTrue(workout.getComments().size() == 1);
        workout.addComment("Comment 2");
        assertTrue(workout.getComments().size() == 2);
        assertEquals("Comment 1", workout.getComments().get(0));
        assertEquals("Comment 2", workout.getComments().get(1));

    }
}
