import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class NoteMaster {
    private static ArrayList<String> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("=================================");
        System.out.println("          Note Master            ");
        System.out.println(" --- A simple To-Do List Application By Tharul Jayasundara --- ");
        System.out.println("=================================\n");

        do {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Edit Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    addTask(scanner);
                    break;
                case "2":
                    removeTask(scanner);
                    break;
                case "3":
                    editTask(scanner);
                    break;
                case "4":
                    viewAllTasks();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        if (!task.isEmpty() && isValidDate(date)) {
            taskList.add(task + " - " + date);
            System.out.println("Task added successfully!\n");
        } else {
            System.out.println("Invalid task or date. Please try again.\n");
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter the task number to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        if (index > 0 && index <= taskList.size()) {
            taskList.remove(index - 1);
            System.out.println("Task removed successfully!\n");
        } else {
            System.out.println("Invalid task number. Please try again.\n");
        }
    }

    private static void editTask(Scanner scanner) {
        System.out.print("Enter the task number to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        if (index > 0 && index <= taskList.size()) {
            String selectedTask = taskList.get(index - 1);
            String[] parts = selectedTask.split(" - ");
            System.out.print("Edit task (" + parts[0] + "): ");
            String newTask = scanner.nextLine();
            System.out.print("Edit date (" + parts[1] + ") (yyyy-MM-dd): ");
            String newDate = scanner.nextLine();
            if (!newTask.isEmpty() && isValidDate(newDate)) {
                taskList.set(index - 1, newTask + " - " + newDate);
                System.out.println("Task edited successfully!\n");
            } else {
                System.out.println("Invalid task or date. Please try again.\n");
            }
        } else {
            System.out.println("Invalid task number. Please try again.\n");
        }
    }

    private static void viewAllTasks() {
        System.out.println("All Tasks:");
        System.out.println("==========");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
        System.out.println();
    }

    private static boolean isValidDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
