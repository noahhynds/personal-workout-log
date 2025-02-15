package model;

import java.util.*;

// Represent a workout having exercises

public class Workout {

    // EFFECTS: creates a workout with no exercises added yet and a status of not
    // completed yet and ID
    public Workout() {

    }

    // REQUIRES: workout has been created and exercise not already in list
    // cannot be empty string
    // MODIFIES: this
    // EFFECTS: adds exercise to workout and return true
    // if exersize is in already in list, return false
    public boolean addExercise(String exercise) {
        return true;
    }

    // REQUIRE: workout has been created
    // cannot be empty string
    // MODIFIES: this
    // EFFECTS: add commet to workout
    public void addComment(String comment) {

    }

    // REQUIRES: workout has been created
    // EFFECTS: returns list of exercises
    // if no exercises add return null
    public List<String> getAllExercises() {
        return null;
    }

    // REQUIRES: workout
    // MODIFIES: this
    // EFFECTS: mark workout as complete
    public void markWorkoutAsComplete() {

    }

}
