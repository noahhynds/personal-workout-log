package ui.tabs;

import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import ui.WorkoutLogUI;
import model.Workout;
import model.WorkoutLog;

public class OptionsTab extends Tab {
    private JButton addExerciseButton;

    public OptionsTab(WorkoutLogUI workoutLogUI) {
        super(workoutLogUI);

        setLayout(new FlowLayout());

        addExerciseButton = new JButton("Add Exercise");

        add(addExerciseButton);

        addExerciseButton.addActionListener(e -> showWorkoutSelectionWindow());
    }

    // EFFECTS: Shows a window with all workouts as buttons
    private void showWorkoutSelectionWindow() {
        WorkoutLog workoutLog = getWorkoutLog().getWorkoutLog();
        List<Workout> workouts = workoutLog.getWorkouts();

        if (workouts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No workouts available. Create one first.");
            return;
        }

        // Create a new frame to display workouts
        JFrame workoutFrame = new JFrame("Select a Workout");
        workoutFrame.setLayout(new GridLayout(0, 1));

        for (Workout workout : workouts) {
            JButton workoutButton = new JButton(workout.getTitle());
            workoutButton.addActionListener(e -> handleAddExercise(workout, workoutFrame));
            workoutFrame.add(workoutButton);
        }

        workoutFrame.pack();
        workoutFrame.setLocationRelativeTo(this);
        workoutFrame.setVisible(true);
    }

    // EFFECTS: Handles adding an exercise to the selected workout and closes the window
    private void handleAddExercise(Workout workout, JFrame workoutFrame) {
        String exercise = JOptionPane.showInputDialog(this, "Enter exercise name for " + workout.getTitle() + ":");

        if (exercise != null && !exercise.trim().isEmpty()) {
            workout.addExercise(exercise.trim());
            JOptionPane.showMessageDialog(this, "Exercise added to " + workout.getTitle() + "!");

            // Refresh WorkoutsTab to display the new exercise
            getWorkoutLog().getWorkoutsTab().displayWorkouts();
        }

        workoutFrame.dispose(); // Close the workout selection window
    }
}
