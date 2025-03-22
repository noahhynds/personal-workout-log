package ui.tabs;

import java.awt.FlowLayout;

import javax.swing.*;

import ui.WorkoutLogUI;

// USED THE SMARTHOME AS REFERENCE
public abstract class Tab extends JPanel {

    private final WorkoutLogUI workoutLog;

    // EFFECTS: Tab abstract for my other tabs
    public Tab(WorkoutLogUI workoutLog) {
        this.workoutLog = workoutLog;
    }

    // EFFECTS: creates button row
    public JPanel buttonRow(JButton b) {
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());

        jp.add(b);

        return jp;
    }

    // EFFECTS: returns workoutlog ui
    public WorkoutLogUI getWorkoutLog() {
        return workoutLog;
    }

}
