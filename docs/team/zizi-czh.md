# Chen ZI Han - Project Portfolio Page

## Project: FITZ
Fitz - the ultimate fitness app for individuals who are passionate about their health and fitness.
Users can achieve their fitness goals and track their progress with ease.
This innovative app is designed for users who prefer a CLI format,
making it a user-friendly option for anyone who wants to keep their fitness routine on track.


### Given Below are my contribution to the project

- Code Contributed: [RepoCode](https://nus-cs2113-ay2223s2.github.io/tp-dashboard/?search=ZIZI-CZH&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2023-02-17)

- Implementation: Added list and view for workout so that the user can track their exercise history
  
    - What it does: List all the dates and workouts that have been entered by the user before so that they have better insight.
    - In oder to let the user be more clear about what are the exercise they have done for each workout
- Implementation: Added storage for workout and food list

    - What is does: record the workouts data that been entered by the users and record the food name and 
    - the food calories so that user do not need to enter the information every time

- Contribute to DG:
  - Draw sequence diagram, architecture and class diagram for all the components which include Storage, Ui, Workout, Calories
  - and Parser.
  - Explain how each component work in details
  
- Contributions to team based tasks
- 
  - Contribute to the testing of program
    - [[1]](https://github.com/AY2223S2-CS2113-T14-1/tp/issues/90)
    - [[2]](https://github.com/AY2223S2-CS2113-T14-1/tp/pull/89)
  - Assisted team to fix bugs
  - Reviewed and Commented on team's PR code with improvement suggestions
    - [[1]](https://github.com/AY2223S2-CS2113-T14-1/tp/pull/86)



    
    
This is what l implemented for previous version before V2.1:

- Implemented Features: Starting a New Workout Day and Adding New Workouts
    - What it Does: Enables users to enter the date they want to begin tracking their fitness progress and add the names of their workouts for that day.
    - Justification: By allowing users to select the specific date they want to start tracking their workouts, the app becomes more flexible and personalized to their needs.
      Additionally, allowing users to add multiple workouts for each day enables them to record a more comprehensive view of their exercise routine.
    - Key Highlights: The app requires users to enter the date before they can begin tracking their workouts, as this is essential for accurate record keeping.
      Furthermore, the app permits users to add new workouts to previous days' records, in case they missed a workout or want to add a previously unrecorded workout.
      However, if the user enters the same workout name for a given date, the app will assume it refers to the same workout and update the existing record accordingly.

- Implemented Features: Adding Exercises to Current Workout
    - What it Does: Enables users to add exercises to their current workout, including the exercise name, weight, and repetitions per set (RPS).
    - Justification: Users must add exercises to a specific day and workout, similar to adding a new workout. The app allows for the possibility of duplicate exercise sets,
      since users may want to record multiple sets of the same exercise within a single workout session.
    - Key Highlights: Users can follow a standardized format to enter their exercise records, including the exercise name, weight used, and RPS.
      This ensures that the app can accurately record and display the user's workout progress over time.

- Implemented features: List of All Recorded Days and View Workouts by Day
    - What it Does: Provides users with a list of all the dates they have previously entered into the app,
      as well as the ability to view their workout records for a specific day.
    - Justification: The app displays a list of all entered dates, even if no workouts have been recorded for that day, as long as the date was entered in the proper format.
      Similarly, the view function will display all previously entered workouts for a specific day, even if no exercises were completed on that day.
      This ensures that users have a clear and comprehensive overview of their exercise history.
    - Key Highlights: Users can use the list of recorded days and view function to gain insights into their exercise history,
      which can inform their future workout plans. By providing users with a complete record of their workout history, the app can help users to stay motivated and track their progress over time.

- Implemented features: Workout Data Storage
    - What it Does: The app automatically saves any changes made to the workout records in an external .txt file when the user exits the app, and retrieves it when the app is opened again.
    - Justification: Justification: Enabling users to use the app at different times requires a reliable way of storing their data, ensuring that their progress is accurately tracked and readily available.
    - Key Highlights: Key Highlights: Properly exiting the app is crucial for the workout data to be saved.


