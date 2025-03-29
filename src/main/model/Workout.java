package model;

import java.util.*;
import java.time.LocalDate;

// Represent a workout having exercises

public class Workout {

    private String id;
    private LocalDate date;
    private String title;
    private Boolean isComplete;
    private List<String> exercises;
    private List<String> comments;

    // REQUIRES: title to be made, must be non zero string
    // EFFECTS: creates a workout with no exercises added yet and a status of not
    // completed yet, ID, date (default to today's date), and title
    public Workout(String title) {
        this.exercises = new ArrayList<>();
        this.date = LocalDate.now();
        this.title = title;
        this.comments = new ArrayList<>();
        this.isComplete = false;
        this.id = UUID.randomUUID().toString();
    }

    // REQURIES: all parameter
    // EFFECTS: creates a fully populated workout object (already)
    public Workout(String id, String title, LocalDate date, Boolean isComplete, List<String> exercises,
            List<String> comments) {
        this.exercises = exercises;
        this.date = date;
        this.title = title;
        this.comments = comments;
        this.isComplete = isComplete;
        this.id = id;
    }

    // EFFECTS: gets the title of the workout
    public String getTitle() {
        return this.title;
    }

    // REQUIRES: a date
    // MODIFIES: this
    // EFFECTS: sets the date of the workout
    public void setDate(LocalDate date) {
        this.date = date;

        // EventLog
        EventLog.getInstance().logEvent(new Event("Date: " + date + " for workout set"));
    }

    // EFFECTS: get the date of the workout
    public LocalDate getDate() {
        return this.date;
    }

    // EFFECTS: gets id
    public String getId() {
        return this.id;
    }

    // REQUIRES: workout has been created and exercise not already in list
    // cannot be empty string
    // MODIFIES: this
    // EFFECTS: adds exercise to workout and return true
    // if exercise is in already in list, return false
    public boolean addExercise(String exercise) {
        if (exercise == null || exercise.isEmpty()) {
            return false;
        }

        if (!exercises.contains(exercise)) {
            exercises.add(exercise);

            // EventLog
            EventLog.getInstance().logEvent(new Event("Exercise: " + exercise + " added to: " + this.getTitle()));

            return true;
        }
        return false;
    }

    // REQUIRE: workout has been created
    // MODIFIES: this
    // EFFECTS: add comment to workout
    public void addComment(String comment) {
        this.comments.add(comment);
        // EventLog
        EventLog.getInstance().logEvent(new Event("Comment: " + comment + " added to: " + this.getTitle()));

    }

    // EFFECTS: gets comments
    public List<String> getComments() {
        return this.comments;
    }

    // EFFECTS: returns list of exercises
    // if no exercises return empty list
    public List<String> getAllExercises() {
        if (!exercises.isEmpty()) {
            return exercises;
        }
        return Collections.emptyList();
    }

    // REQUIRES: workout
    // MODIFIES: this
    // EFFECTS: mark workout as complete
    public void markWorkoutAsComplete() {
        this.isComplete = true;

        // EventLog
        EventLog.getInstance().logEvent(new Event(this.getTitle() + " marked as complete"));

    }

    // EFFECTS: gets workout status
    public boolean getStatusOfWorkout() {
        return this.isComplete;
    }

}
