-------------------------
🟧 Note Master
-------------------------


--------
- NoteMaster is a simple Java application for managing a to-do list with tasks and associated dates. This version of NoteMaster introduces features to add, edit, remove, view, and filter tasks, along with data persistence using file handling. The application provides a simple and effective way to keep track of tasks and their deadlines.

--------------
![image](https://github.com/Tharul-J/Note-Master/assets/171511675/47ac32f1-11bd-47c9-a905-a07f14c052ac)
![image](https://github.com/Tharul-J/Note-Master/assets/171511675/29001ca0-d3bc-4a46-a00a-de3c4313ef85)

--------------

-------------------------
## Application Features
------------------------

- **Components Used:** [ `ArrayList`, `Scanner`, `SimpleDateFormat`, `File I/O (BufferedReader, BufferedWriter)` ]
  
     - ArrayList: Stores the list of tasks dynamically.
     - Scanner: Captures user input from the command line.
     - SimpleDateFormat: Validates the date format for tasks.
     - File I/O (BufferedReader, BufferedWriter): Manages reading from and writing to a text file for task persistence.
-------------------------
  
- **Functionalities:** [ `Add Task`, `Remove Task`, `Edit Task`, `View All Tasks`, `Filter Tasks by Month` ]

   **1) Add Task:**
  
     - Users can add new tasks with an associated date.
     - The task and date are validated for correct format (yyyy-MM-dd).
     - New Feature: Tasks are saved to a text file (tasks.txt) for persistence.

    **2) Remove Task:**
  
     - Users can remove tasks by specifying the task number.
     - New Feature: After removal, the tasks are updated in the text file.

    **3) Edit Task:**
  
     - Users can edit existing tasks and their dates.
     - The new task and date are validated for correctness.
     - New Feature: Changes are saved to the text file after editing.

    **4) View All Tasks:**
  
     - Displays all tasks and their dates in the console.
     - Lists tasks with their respective numbers for easy reference.

    **5) Filter Tasks by Month:**
  
     - Users can filter and view tasks that fall within a specified month.
     - New Feature: Allows users to see tasks for a specific month (e.g., MM).


-------------------------

