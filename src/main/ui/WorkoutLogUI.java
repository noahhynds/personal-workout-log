package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.*;

import ui.tabs.WorkoutsTab;
import ui.tabs.HomeTab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WorkoutLogUI extends JFrame implements ActionListener {
    public static final int HOME_TAB = 0;
    public static final int WORKOUTS_TAB = 1;
    public static final int EXERCISES_TAB = 2;
    public static final int COMMENTS_TAB = 3;
    private WorkoutLog workoutLog;
    public static final int width = 600;
    public static final int height = 600;
    private JMenuBar menuBar;
    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem quitItem;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/workoutlog.json";
    private static final String greet = "Welcome to your WorkoutLog";
    private JPanel options;
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

        sidebar.add(homeTab, HOME_TAB);
        sidebar.setTitleAt(HOME_TAB, "Home");
        sidebar.add(workoutsTab, WORKOUTS_TAB);
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

    // EFFECTS: saves workoutLog
    private void saveWorkoutLog() {
        jsonWriter.write(workoutLog);
        System.out.println("Saved to " + JSON_STORE);
    }

    // EFFECTS: loads workroom from file
    private void loadWorkoutLog() {
        workoutLog = jsonReader.load();
        System.out.println("Loaded from " + JSON_STORE);

    }
}