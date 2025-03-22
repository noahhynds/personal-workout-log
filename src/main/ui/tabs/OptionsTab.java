package ui.tabs;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import ui.WorkoutLogUI;
import model.Workout;
import model.WorkoutLog;
import ui.Buttons;

public class OptionsTab extends Tab {
    private JButton addExerciseButton;
    private JButton addCommentButton;

    // EFFECTS: options tab
    public OptionsTab(WorkoutLogUI workoutLogUI) {
        super(workoutLogUI);

        this.setLayout(new FlowLayout());

        addExerciseButton = new JButton(Buttons.ADD_EXERCISE.getValue());
        addCommentButton = new JButton(Buttons.ADD_COMMENTS.getValue());

        this.add(addExerciseButton);
        this.add(addCommentButton);

        addExerciseButton.addActionListener(e -> showWorkoutSelectionWindowExercise());
        addCommentButton.addActionListener(e -> showWorkoutSelectionWindowComment());
    }

    // EFFECTS: Shows a window with all workouts as buttons
    private void showWorkoutSelectionWindowExercise() {
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

    // EFFECTS: Shows a window with all workouts as buttons
    private void showWorkoutSelectionWindowComment() {
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
            workoutButton.addActionListener(e -> handleAddComment(workout, workoutFrame));
            workoutFrame.add(workoutButton);
        }

        workoutFrame.pack();
        workoutFrame.setLocationRelativeTo(this);
        workoutFrame.setVisible(true);
    }

    // EFFECTS: Handles adding an exercise to the selected workout and closes the
    // window
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

    // EFFECTS: Handles adding a comment to the selected workout and closes the
    // window
    private void handleAddComment(Workout workout, JFrame workoutFrame) {
        String comment = JOptionPane.showInputDialog(this, "Enter comment for " + workout.getTitle() + ":");

        if (comment != null && !comment.trim().isEmpty()) {
            workout.addComment(comment.trim());
            JOptionPane.showMessageDialog(this, "Comment added to " + workout.getTitle() + "!");

            // Refresh WorkoutsTab to display the new exercise
            getWorkoutLog().getWorkoutsTab().displayWorkouts();
        }

        workoutFrame.dispose(); // Close the workout selection window
    }
}
