
package easykhanban;

public class Task {
    private String taskId;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private String status;
    private double taskDuration;

    // Updated constructor to include taskDuration
    public Task(String taskId, String taskName, String taskDescription, String developerDetails, double taskDuration, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.status = status;
    }

    public static boolean checkTaskDescription(String taskDescription) {
        return taskDescription != null && !taskDescription.isEmpty() && taskDescription.length() <= 50;
    }
    
    public static String createTaskID(String taskName, String developerDetails, int taskNumber) {
        String taskNamePart = taskName.substring(0, Math.min(2, taskName.length())).toUpperCase();
        
        // Assuming developerDetails is in the format "FirstName LastName"
        String[] names = developerDetails.split(" ");
        String firstName = names[0];
        String firstNamePart = firstName.substring(Math.max(firstName.length() - 3, 0)).toUpperCase();
        
        return taskNamePart + ":" + taskNumber + ":" + firstNamePart;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public String getStatus() {
        return status;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public String printTaskDetails() {
        return "Task ID: " + taskId + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription + "\nDeveloper Details: " + developerDetails + "\nStatus: " + status + "\nDuration: " + taskDuration + " hours";
    }

    public static int returnTotalHours(Task[] tasks) {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }
}