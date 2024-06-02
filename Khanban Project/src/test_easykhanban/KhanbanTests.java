package test_easykhanban; 

import static org.junit.Assert.assertEquals;
import org.junit.Test; 
import easykhanban.Task; 

public class KhanbanTests {
    
    @Test
    public void testTaskDescriptionLengthSuccess() {
        String taskDescription = "Create Login to authenticate users";
        boolean result = Task.checkTaskDescription(taskDescription);
        assertEquals(true, result);
    }

    @Test
    public void testTaskDescriptionLengthFailure() {
        String taskDescription = "Create Add Task feature to add tasks for users with long descriptions";
        boolean result = Task.checkTaskDescription(taskDescription);
        assertEquals(false, result);
    }

    @Test
    public void testTaskIDGeneration() {
        String taskName = "Login Feature";
        String developerDetails = "Phephi Harrison";
        int taskNumber = 1;
        String expectedTaskID = "LO:1:PHI"; // Corrected taskName and expectedTaskID
        String actualTaskID = Task.createTaskID(taskName, developerDetails, taskNumber);
        assertEquals(expectedTaskID, actualTaskID);
    }

    @Test
    public void testTotalHoursAccumulation() {
        Task[] tasks = new Task[2];
        tasks[0] = new Task("AD:1:BYN", "Login Feature", "Create Login to authenticate users", "Robyn Gandashanga", 8, "To Do");
        tasks[1] = new Task("AD:2:IKE", "Add Task Feature", "Create Add Task feature", "Mike Willamson", 10, "Doing");
        int expectedTotalHours = 18;
        int actualTotalHours = Task.returnTotalHours(tasks);
        assertEquals(expectedTotalHours, actualTotalHours);
    }

    @Test
    public void testTotalHoursAccumulationWithAdditionalData() {
        Task[] tasks = new Task[5];
        tasks[0] = new Task("AD:1:BYN", "Login Feature", "Create Login to authenticate users", "Robyn Gandashanga", 10, "To Do");
        tasks[1] = new Task("AD:2:IKE", "Add Task Feature", "Create Add Task feature", "Mike Jones", 12, "Doing");
        tasks[2] = new Task("AD:3:MES", "Go Golfing", "Go golfing for fun", "James May", 55, "To Do");
        tasks[3] = new Task("AD:4:JN", "Complain about hair", "Complain about hair", "Charles Williams", 11, "Doing");
        tasks[4] = new Task("AD:5:JN", "Complain about why code is not running", "Complain about why code is not running", "Junior Malinga", 1, "To Do");
        
        int expectedTotalHours = 89; // 10 + 12 + 55 + 11 + 1
        int actualTotalHours = Task.returnTotalHours(tasks);
        assertEquals(expectedTotalHours, actualTotalHours);
    }
}
