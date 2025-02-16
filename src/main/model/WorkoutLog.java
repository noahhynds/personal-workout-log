package model;

import java.util.*;

// Represents a list of all workouts
public class WorkoutLog {
    List<Workout> workouts;

    // EFFECTS: creates a workout log with a list of all workouts
    // starts off as empty
    public WorkoutLog() {
        workouts = new ArrayList<>();
    }

    // REQUIRES: workout is complete and not already in workout log and not empty
    // MODIFIES: this
    // EFFECTS: adds a workout to log and return true
    // if workout is in log already return false
    public boolean addWorkoutToLog(Workout workout) {
        if (workout == null || workout.exercises.isEmpty()) {
            return false;
        }

        if (!workouts.contains(workout)) {
            workouts.add(workout);
            return true;
        }
        return false;

    }

    // EFFECTS: gets list of all workouts in the workout log
    // if no workouts return empty list
    public List<Workout> getWorkouts() {
        if (!workouts.isEmpty()) {
            return workouts;
        }
        return Collections.emptyList();
    }

}
