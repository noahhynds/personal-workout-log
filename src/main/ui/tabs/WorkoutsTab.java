package ui.tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.Buttons;
import ui.WorkoutLogUI;
import model.*;

public class WorkoutsTab extends Tab {
    private JButton viewWrkt;
    private JButton addEx;
    Workout workout;
    WorkoutLog workoutLog;

    public WorkoutsTab(WorkoutLogUI workoutLog) {
        super(workoutLog);
        viewWorkoutsButton();
        addExercisesButton();
    }

    // EFFECTS: button to views workouts
    public void viewWorkoutsButton() {
        viewWrkt = new JButton();
        viewWrkt.setBounds(50, 10, 100, 100);
        viewWrkt.setText(Buttons.VIEW_WORKOUTS.getValue());
        viewWrkt.setFocusable(false);
        viewWrkt.addActionListener(e -> viewWorkoutsButton());
        this.add(viewWrkt);
    }

    // EFFECTS: button to add exercise
    public void addExercisesButton() {
        addEx = new JButton();
        addEx.setBounds(50, 30, 100, 100);
        addEx.setText(Buttons.ADD_EXERCISE.getValue());
        addEx.setFocusable(false);
        this.add(addEx);
    }

    // EFFECTS: displays all workouts
    public void displayWorkouts() {
        // workoutLog.getWorkouts();

    }

    // EFFECTS: add exercise to workout
    public void addExercise() {
        //
    }

}
