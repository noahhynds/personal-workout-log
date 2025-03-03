package persistence;

import model.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

// Used the JsonSterilizationDemo as a reference

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workoutlog from file and returns it
    public WorkoutLog load() {
        WorkoutLog workoutLog = new WorkoutLog();
        // read file

        File path = new File(source);

        if (!path.exists()) {
            return workoutLog; // Return empty log if file doesn't exist
        }

        String file = readFile(source);
        JSONArray jsonArray = new JSONArray(file);
        // extract workout 1 at a time
        for (int i = 0; i < jsonArray.length(); i++) {
            // add workout to workoutlog
            JSONObject workoutJsonObject = jsonArray.getJSONObject(i);
            Workout workout = fromJsonToObject(workoutJsonObject);
            workoutLog.addWorkoutToLog(workout);
        }
        return workoutLog;
    }

    private Workout fromJsonToObject(JSONObject jsonObject) {
        String id = jsonObject.getString("ID");
        LocalDate date = LocalDate.parse(jsonObject.getString("Date"));
        String title = jsonObject.getString("Title");
        Boolean isComplete = jsonObject.getBoolean("Status");
        List<String> comments = new ArrayList<>();
        JSONArray commentsArray = jsonObject.getJSONArray("Comments");
        for (int i = 0; i < commentsArray.length(); i++) {
            comments.add(commentsArray.getString(i));
        }
        List<String> exercises = new ArrayList<>();
        JSONArray exercisesArray = jsonObject.getJSONArray("Exercises");
        for (int i = 0; i < exercisesArray.length(); i++) {
            exercises.add(exercisesArray.getString(i));
        }
        return new Workout(id, title, date, isComplete, exercises, comments);

    }

    // Used the JsonSterilizationDemo as a reference
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        } catch (IOException | JSONException e) {
            System.out.println("ERROR LOADING FILE");
        }

        return contentBuilder.toString();
    }
}
