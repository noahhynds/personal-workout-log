# My Personal Gym Log (CPSC210)


This application is a weight training workout log. This training log will be used by myself to track my progress over time. This application is of interest to me as weight training is one of my main recreational activities.

The main feature of this application is workout session management

## Workout Session Management

This functionality will include:

- Workout Session Creation
- Training Notes and Observations
- Workout Session Review

## User Stories

- As a user, I want to create a new workout
- As a user, I want to add an exercise to a workout
- As a user, I want to add *comments* to the workout
- As a user, I want to view the list of exercises in the current workout
- As a user, I want to mark a workout as complete
- As a user, I want to add a workout to my log
- As a user, I want to view all workouts in my log

- As a user, I want to be able to save my workouts to file
- As a user, I want to be able to load my workout histroy from file


## Instructions for End User

- To add workouts to the workout log. You click on the CREATE NEW button on the HOME TAB.
- The OPTIONS TAB allows the user to add exercises and comments to a workout of choice. You either click on the ADD EXERCISE or ADD COMMENT. A window will pop up and you choose a workout to add your exercise or comment to.
- You can locate my visual component by going to the tabs on the left. Workouts tab will see all the workouts with any exercises that were added.
- To view all workouts go to the WORKOUTS TAB. This will display all the workouts with exercises and comments.
- To save, load, and quit go to the top left and click on the FILE. To save press SAVE, to load press LOAD, and to quit press QUIT.

## Phase 4: Task 2

- EVENT LOG:
Sat Mar 29 12:49:46 PDT 2025
Workout: Push Day 1 added to log
Sat Mar 29 12:49:52 PDT 2025
Workout: Pull Day 1 added to log
Sat Mar 29 12:49:57 PDT 2025
Workout: Legs Day 1 added to log
Sat Mar 29 12:50:09 PDT 2025
Exercise: Bench Press added to: Push Day 1
Sat Mar 29 12:50:23 PDT 2025
Exercise: Shoulder Press added to: Push Day 1
Sat Mar 29 12:50:32 PDT 2025
Exercise: Pull ups added to: Pull Day 1
Sat Mar 29 12:50:41 PDT 2025
Exercise: Barbell row added to: Pull Day 1
Sat Mar 29 12:50:46 PDT 2025
Exercise: Squats added to: Legs Day 1
Sat Mar 29 12:50:54 PDT 2025
Exercise: Hamstring curls added to: Legs Day 1
Sat Mar 29 12:51:00 PDT 2025
Comment: Felt strong added to: Push Day 1
Sat Mar 29 12:51:12 PDT 2025
Comment: Hit a PR added to: Pull Day 1
Sat Mar 29 12:51:18 PDT 2025
Comment: Felt tired added to: Legs Day 1

## Phase 4: Task 3

- If I had more time I would refactor the methods that allow the user to add a commment and an exercise. They have the exact same function (both have a window popping up and both allow the user to click onto a workou) they just add either comments or exercises (end up in different location).