package ui.tabs;

import java.awt.*;
import javax.swing.*;
import ui.WorkoutLogUI;
import model.WorkoutLog;
import model.Workout;
import java.util.List;

public class WorkoutsTab extends Tab {
    private JTextArea workoutDisplayArea;

    // EFFECTS: displays all workouts with exercises if they have been added
    public WorkoutsTab(WorkoutLogUI workoutLogUI) {
        super(workoutLogUI);
        setLayout(new BorderLayout());

        workoutDisplayArea = new JTextArea();
        workoutDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(workoutDisplayArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    // EFFECTS: displays all workouts along with their exercises
    public void displayWorkouts() {
        WorkoutLog workoutLog = getWorkoutLog().getWorkoutLog();
        List<Workout> workouts = workoutLog.getWorkouts();

        StringBuilder displayText = new StringBuilder();

        for (Workout workout : workouts) {
            displayText.append(workout.getTitle()).append("\n");
            displayText.append("   Exercises:").append("\n");
            for (String exercise : workout.getAllExercises()) {
                displayText.append("      - ").append(exercise).append("\n");
            }
            displayText.append("   Comments:").append("\n");
            for (String comment : workout.getComments()) {
                displayText.append("      - ").append(comment).append("\n");
            }
            displayText.append("\n"); // Add an empty line between workouts
        }

        workoutDisplayArea.setText(displayText.toString());
    }
}
