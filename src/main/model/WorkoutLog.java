package model;

import java.util.*;

// Represents a list of all workouts
public class WorkoutLog {
    private List<Workout> workouts;

    // EFFECTS: creates a workout log with a list of all workouts
    // starts off as empty
    public WorkoutLog() {
        workouts = new ArrayList<>();
    }

    // REQUIRES: not already in workout log and not null
    // MODIFIES: this
    // EFFECTS: adds a workout to log and return true
    // if workout is in log already return false
    public boolean addWorkoutToLog(Workout workout) {
        if (workout == null) {
            return false;
        }

        if (!workouts.contains(workout)) {
            workouts.add(workout);

            // EventLog
            EventLog.getInstance().logEvent(new Event("Workout: " + workout.getTitle() + " added to log"));

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

    // EFFECTS: gets singular workout
    public Workout getWorkout(String id) {

        for (Workout w : workouts) {
            if (id.equals(w.getId())) {
                return w;
            }

        }
        return null;
    }

}
