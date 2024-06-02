
package easykhanban;

import javax.swing.JOptionPane;
import management.AccountManager;
import management.UserInterface;
import java.util.ArrayList;
import java.util.List;

public class Khanban {

    private static List<Task> tasks = new ArrayList<>();
    private static List<String> developers = new ArrayList<>();
    private static List<String> taskNames = new ArrayList<>();
    private static List<String> taskIds = new ArrayList<>();
    private static List<Double> taskDurations = new ArrayList<>();
    private static List<String> taskStatuses = new ArrayList<>();

    public static void startKhanban() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            int choice = showMainMenu();
            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    moreOptions();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                    AccountManager accountManager = new AccountManager();
                    UserInterface ui = new UserInterface(accountManager);
                    ui.start();
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static int showMainMenu() {
        String input = JOptionPane.showInputDialog(
                "Choose an option:\n" +
                "1. Add Task\n" +
                "2. Show Report\n" +
                "3. More Options\n" +
                "4. Quit");

        if (input == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private static void moreOptions() {
        while (true) {
            int choice = showMoreOptionsMenu();
            switch (choice) {
                case 1:
                    displayTasksWithStatusDone();
                    break;
                case 2:
                    displayTaskWithLongestDuration();
                    break;
                case 3:
                    searchTaskByName();
                    break;
                case 4:
                    searchTasksByDeveloper();
                    break;
                case 5:
                    deleteTaskByName();
                    break;
                case 6:
                    return; // Return to main menu
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static int showMoreOptionsMenu() {
        String input = JOptionPane.showInputDialog(
                "More Options:\n" +
                "1. Display Tasks with Status 'Done'\n" +
                "2. Display Task with Longest Duration\n" +
                "3. Search Task by Name\n" +
                "4. Search Tasks by Developer\n" +
                "5. Delete Task by Name\n" +
                "6. Back to Main Menu");

        if (input == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return -1;
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    private static void addTasks() {
        String enterTask = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
        if (enterTask == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int numTasks;
        try {
            numTasks = Integer.parseInt(enterTask);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number of tasks. Cancelling...", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalHours = 0;
        StringBuilder taskDetails = new StringBuilder();

        for (int i = 0; i < numTasks; i++) {
            String taskName;
            while (true) {
                taskName = JOptionPane.showInputDialog("What is the name of the task?");
                if (taskName == null) {
                    JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (taskName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The Task Name cannot be empty. Please enter a task name.");
                } else {
                    JOptionPane.showMessageDialog(null, "Task Name successfully captured.");
                    break;
                }
            }

            String taskDescription;
            while (true) {
                taskDescription = JOptionPane.showInputDialog("Provide a description of task " + (i + 1) + ":");
                if (taskDescription == null) {
                    JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (taskDescription.isEmpty() || taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "The task description cannot be empty and must be less than 50 characters.");
                } else {
                    JOptionPane.showMessageDialog(null, "The task description has been successfully captured.");
                    break;
                }
            }

            String developerDetails;
            while (true) {
                developerDetails = JOptionPane.showInputDialog("Please enter your developer details, which are your first and last name:");
                if (developerDetails == null) {
                    JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (developerDetails.isBlank()) {
                    JOptionPane.showMessageDialog(null, "The developer's details cannot be left empty.");
                } else {
                    JOptionPane.showMessageDialog(null, "The developer's details have been successfully captured.");
                    break;
                }
            }

            String statusText = "";
            while (true) {
                String statusInput = JOptionPane.showInputDialog(
                        "Select the status of the task:\n" +
                        "1. To do\n" +
                        "2. Doing\n" +
                        "3. Done");
                if (statusInput == null) {
                    JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int status;
                try {
                    status = Integer.parseInt(statusInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 3.");
                    continue;
                }
                switch (status) {
                    case 1:
                        statusText = "To do";
                        break;
                    case 2:
                        statusText = "Doing";
                        break;
                    case 3:
                        statusText = "Done";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please enter a number between 1 and 3.");
                        continue;
                }
                break;
            }

            String taskId = Task.createTaskID(taskName, developerDetails, i + 1);
            String hoursInput;
            double taskDuration;
            while (true) {
                hoursInput = JOptionPane.showInputDialog("Enter the estimated amount of hours for task " + (i + 1) + ":");
                if (hoursInput == null) {
                    JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                try {
                    taskDuration = Double.parseDouble(hoursInput);
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for hours.");
                }
            }

            Task task = new Task(taskId, taskName, taskDescription, developerDetails, taskDuration, statusText);
            tasks.add(task);
            developers.add(developerDetails);
            taskNames.add(taskName);
            taskIds.add(taskId);
            taskDurations.add(taskDuration);
            taskStatuses.add(statusText);

            totalHours += taskDuration;

            taskDetails.append("Task ID: ").append(taskId).append("\n");
            taskDetails.append("Task Name: ").append(taskName).append("\n");
            taskDetails.append("Task Description: ").append(taskDescription).append("\n");
            taskDetails.append("Developer Details: ").append(developerDetails).append("\n");
            taskDetails.append("Status: ").append(statusText).append("\n");
            taskDetails.append("Duration: ").append(taskDuration).append(" hours\n\n");
        }

        JOptionPane.showMessageDialog(null, taskDetails.toString());
        JOptionPane.showMessageDialog(null, "Total hours for all tasks: " + totalHours);
    }

    private static void showReport() {
        StringBuilder report = new StringBuilder();
        for (Task task : tasks) {
            report.append(task.printTaskDetails()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Full Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase("Done")) {
                result.append("Developer: ").append(task.getDeveloperDetails()).append(", Task Name: ").append(task.getTaskName()).append(", Duration: ").append(task.getTaskDuration()).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Tasks with Status 'Done'", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayTaskWithLongestDuration() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.", "Longest Task Duration", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Task longestTask = tasks.get(0);
        for (Task task : tasks) {
            if (task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }

        String result = "Developer: " + longestTask.getDeveloperDetails() + ", Duration: " + longestTask.getTaskDuration() + " hours";
        JOptionPane.showMessageDialog(null, result, "Task with Longest Duration", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the Task Name to search:");
        if (taskName == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                String result = "Task Name: " + task.getTaskName() + ", Developer: " + task.getDeveloperDetails() + ", Status: " + task.getStatus();
                JOptionPane.showMessageDialog(null, result, "Task Found", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog("Enter the Developer Name to search:");
        if (developer == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder result = new StringBuilder("Tasks assigned to " + developer + ":\n");
        for (Task task : tasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developer)) {
                result.append("Task Name: ").append(task.getTaskName()).append(", Status: ").append(task.getStatus()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Tasks by Developer", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the Task Name to delete:");
        if (taskName == null) {
            JOptionPane.showMessageDialog(null, "Cancelling...", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                tasks.remove(i);
                developers.remove(i);
                taskNames.remove(i);
                taskIds.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' deleted.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        startKhanban();
    }
}
