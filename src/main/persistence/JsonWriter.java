package persistence;

import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

// Used the JsonSterilizationDemo as a reference

// Represents a writer that saves to file in JSON format of workout log
public class JsonWriter {
    private static final int TAB = 4;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    private JSONObject fromObjectToJson(Workout workout) {
        JSONObject jsonObject = new JSONObject();
        // gather parameters
        jsonObject.put("Date", workout.getDate().toString());
        jsonObject.put("Title", workout.getTitle());
        jsonObject.put("ID", workout.getId());
        jsonObject.put("Status", workout.getStatusOfWorkout());
        // go through array
        JSONArray exercisesArray = new JSONArray();
        for (String exercises : workout.getAllExercises()) {
            exercisesArray.put(exercises);

        }
        jsonObject.put("Exercises", exercisesArray);
        JSONArray commentsArray = new JSONArray();
        for (String comments : workout.getComments()) {
            commentsArray.put(comments);

        }
        jsonObject.put("Comments", commentsArray);

        return jsonObject;
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workoutlog to file
    public void write(WorkoutLog workoutLog) {

        try {

            JSONArray jsonArray = new JSONArray();
            // converting
            for (Workout workout : workoutLog.getWorkouts()) {
                JSONObject workoutJsonObject = fromObjectToJson(workout);
                jsonArray.put(workoutJsonObject);
            }
            Files.writeString(Paths.get(destination), jsonArray.toString(TAB));
            // save(jsonArray.toString(TAB));

        } catch (IOException e) {
            System.out.println("ERROR SAVING WORKOUTS");
        }
    }
}