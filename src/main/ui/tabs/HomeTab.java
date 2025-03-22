package ui.tabs;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Workout;
import ui.WorkoutLogUI;
import ui.Buttons;

public class HomeTab extends Tab {
    private JLabel welcome;
    private JButton addWrkt;

    // EFFECTS: crates home tab
    public HomeTab(WorkoutLogUI workoutlog) {
        super(workoutlog);
        welcome = new JLabel();
        welcome.setText("Welcome To Your WorkoutLog:");
        this.add(welcome);
        format();
    }

    // EFFECTS: formats the buttons
    public void format() {
        // add option to add workout
        addWrkt = new JButton();
        addWrkt.setBounds(200, 10, 200, 100);
        addWrkt.setText(Buttons.CREATE_WORKOUT.getValue());
        addWrkt.setFocusable(false);
        addWrkt.addActionListener(e -> addWorkoutButton());
        this.add(addWrkt);
    }

    // EFFECTS: creates a new workout and adds it to the log
    public void addWorkoutButton() {
        String title = JOptionPane.showInputDialog(this, "What is the title?");
        Workout workout = new Workout(title.trim());
        getWorkoutLog().getWorkoutLog().addWorkoutToLog(workout);
        getWorkoutLog().getWorkoutsTab().displayWorkouts();
        JOptionPane.showMessageDialog(this, "Successfully added your workout");
    }

}