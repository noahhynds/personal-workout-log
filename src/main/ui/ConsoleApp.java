package ui;

import model.*;

import java.util.Scanner;

// WorkoutLog menu creation
public class ConsoleApp {
    private Boolean userNotQuit; // lets us know to keep running in main
    private Scanner scanner; // takes inputs from user
    private WorkoutLog workoutLog; // new workout log that stores all workouts

    // EFFECTS: constructs app
    public ConsoleApp() {
        workoutLog = new WorkoutLog();
        userNotQuit = true;
        scanner = new Scanner(System.in);
    }

    // EFFECTS: runs application until user exits
    public void start() {
        while (userNotQuit) {
            displayMenu();
            handleUserInput();
        }
    }

    // EFFECTS: displays a menu with options
    private void displayMenu() {
        System.out.println("\n*** My Workout Log ***");
        System.out.println("1. Create new workout");
        System.out.println("2. Add an exercise");
        System.out.println("3. View all workouts");
        System.out.println("4. Add comment to a workout");
        System.out.println("5. Quit");
        System.out.print("Choose an option (1-5): ");

    }

    // EFFECTS: quits app
    private void quitApp() {
        this.userNotQuit = false;
        System.out.println("Goodbye!");

    }

    // EFFECTS: handles user inputs
    private void handleUserInput() {
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                createWorkout();
                break;
            case "2":
                addExerciseToWorkout();
                break;
            case "3":
                viewWorkouts();
                break;
            case "4":
                addComments();
                break;
            case "5":
                quitApp();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // EFFECTS: adds new workout to workout log with title of users choice
    private void createWorkout() {
        System.out.print("What is the title of your workout: ");
        String title = scanner.nextLine();
        Workout workout = new Workout(title);
        workoutLog.addWorkoutToLog(workout);
        System.out.println("Workout " + title + " created!");

    }

    // EFFECTS: adds exercise to a selected workout
    private void addExerciseToWorkout() {
        System.out.print("Which workout do you want an exercise to (ID): ");
        for (Workout workout : workoutLog.getWorkouts()) {
            System.out.println("\nDate: " + workout.getDate());
            System.out.println("Title: " + workout.getTitle());
            System.out.println("ID: " + workout.getId());
        }

        String workoutChoice = scanner.nextLine();
        Workout w = workoutLog.getWorkout(workoutChoice);
        if (w != null) {
            System.out.print("What exercise do you want to add: ");
            String exercise = scanner.nextLine();
            w.addExercise(exercise);
            System.out.println(exercise + " successfully added");
        } else {
            System.out.println("No workout found for that ID");
        }

    }

    // EFFECTS: views all workouts in workout log
    private void viewWorkouts() {
        System.out.println("\n*** Your Workouts ***");
        for (Workout workout : workoutLog.getWorkouts()) {
            // show date
            System.out.println("\nDate: " + workout.getDate());
            // show title
            System.out.println("Title: " + workout.getTitle());
            // show id
            System.out.println("ID: " + workout.getId());
            // Show exercises
            if (!workout.getAllExercises().isEmpty()) {
                System.out.println("Exercises:");
                for (String exercise : workout.getAllExercises()) {
                    System.out.println("- " + exercise);
                }
            }
            // show comments
            if (!workout.getComments().isEmpty()) {
                System.out.println("Comments:");
                for (String comment : workout.getComments()) {
                    System.out.println("- " + comment);
                }
            }
        }

        if (workoutLog.getWorkouts().isEmpty()) {
            System.out.println("You have added no workouts yet");

        }

    }

    // EFFECTS: add comments to selected workout
    private void addComments() {
        System.out.print("Which workout do you want to add coments to (ID): ");
        for (Workout workout : workoutLog.getWorkouts()) {
            System.out.println("\nDate: " + workout.getDate());
            System.out.println("Title: " + workout.getTitle());
            System.out.println("ID: " + workout.getId());
        }

        String workoutChoice = scanner.nextLine();
        Workout w = workoutLog.getWorkout(workoutChoice);
        if (w != null) {
            System.out.print("Comment: ");
            String comment = scanner.nextLine();
            w.addComment(comment);
            System.out.println("Comment successfully added");
        } else {
            System.out.println("No workout found for that ID");
        }

    }

}
