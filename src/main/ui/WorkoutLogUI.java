package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import ui.tabs.WorkoutsTab;
import ui.tabs.HomeTab;
import ui.tabs.OptionsTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WorkoutLogUI extends JFrame implements ActionListener {
    public static final int HOME_TAB = 0;
    public static final int WORKOUTS_TAB = 1;
    public static final int OPTIONS_TAB = 2;
    private WorkoutLog workoutLog;
    public static final int width = 600;
    public static final int height = 600;
    private JMenuBar menuBar;
    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem quitItem;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);

    private static final String JSON_STORE = "./data/workoutlog.json";
    private static final String greet = "Welcome to your WorkoutLog";
    private JPanel greetings;
    private JTabbedPane sidebar;

    public static void main(String[] args) {
        new WorkoutLogUI();

    }

    // EFFECTS: GUI setup
    public WorkoutLogUI() {
        super("WorkoutLog");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        workoutLog = new WorkoutLog();
        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        menuBar();
        loadTabs();
        sidePane();
        this.add(sidebar);
        this.setVisible(true);
    }

    // EFFECTS: creates sidepane
    public void sidePane() {
        JTabbedPane sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
    }

    // EFFECTS: loads home and workouts tab
    public void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel workoutsTab = new WorkoutsTab(this);
        JPanel optionsTab = new OptionsTab(this);

        sidebar.add(homeTab, HOME_TAB);
        sidebar.setTitleAt(HOME_TAB, "Home");
        sidebar.add(workoutsTab, WORKOUTS_TAB);
        sidebar.add(optionsTab, OPTIONS_TAB);
        sidebar.setTitleAt(OPTIONS_TAB, "Options");
        sidebar.setTitleAt(WORKOUTS_TAB, "Workouts");

    }

    // EFFECTS: creates menu bar to save, load, and quit
    public void menuBar() {
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        quitItem = new JMenuItem("Quit");
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        quitItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

    }

    // EFFECTS: returns a workoutlog
    public WorkoutLog getWorkoutLog() {
        return workoutLog;
    }

    // EFFECTS: gretting that user sees
    public void greetings() {
        greetings = new JPanel();
        greetings.setBounds(width / 2, height / 2, 200, 100);
        JLabel message = new JLabel(greet);
        message.setSize(10, 10);
        greetings.add(message);
        this.add(greetings);

    }

    // EFFECTS: action for menuBar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem) {
            loadWorkoutLog();
        }
        if (e.getSource() == saveItem) {
            saveWorkoutLog();
        }
        if (e.getSource() == quitItem) {
            System.exit(0);
        }
    }

    // EFFECTS: Creates a new workout and adds it to the log
    public void addWorkoutButton() {
        String title = JOptionPane.showInputDialog(this, "What is the title?");
        if (title != null && !title.trim().isEmpty()) {
            Workout workout = new Workout(title.trim());
            getWorkoutLog().addWorkoutToLog(workout); // Add workout to WorkoutLog
            getWorkoutsTab().displayWorkouts(); // Refreshes WorkoutsTab
            JOptionPane.showMessageDialog(this, "Workout added successfully!");
        }
    }

    // EFFECTS: get workout tab
    public WorkoutsTab getWorkoutsTab() {
        return (WorkoutsTab) sidebar.getComponentAt(1);
    }

    // EFFECTS: loads workoutLog from file and refreshes UI
    private void loadWorkoutLog() {
        try {
            workoutLog = jsonReader.load(); // Load the saved WorkoutLog object
            getWorkoutsTab().displayWorkouts(); // Refresh WorkoutsTab to show the loaded workouts
            System.out.println("Loaded from " + JSON_STORE);
            JOptionPane.showMessageDialog(this, "Successfully loaded from " + JSON_STORE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: saves workoutLog to file
    private void saveWorkoutLog() {
        try {
            jsonWriter.write(workoutLog); // Save the current WorkoutLog object
            System.out.println("Saved to " + JSON_STORE);
            JOptionPane.showMessageDialog(this, "Successfully saved to " + JSON_STORE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to save data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}