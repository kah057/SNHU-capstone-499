/**
 * File: TaskServiceTest.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This file defines the TaskService class, a service layer responsible for managing Task objects, which represent individual tasks with unique identifiers, names, and descriptions. 
 * The class maintains a collection of tasks, allowing for the creation, retrieval, updating, and deletion of tasks based on their unique IDs. 
 * It ensures the integrity of the task collection by preventing tasks with duplicate IDs and handling requests for non-existent tasks.
 * */


package Task;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

	// Test adding a task and then retrieving it by its ID.
	
    @Test
    public void testAddAndGetTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        Task task = service.getTask("1");
        assertNotNull(task);
        assertEquals("1", task.getId());
    }

   // Test adding a task with an ID that already exists in the service.
    
    @Test
    public void testAddDuplicateTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        assertThrows(IllegalArgumentException.class, () -> service.addTask("1", "Task2", "This is task 2"));
    }

   // Test deleting a task and then trying to retrieve it.
    
    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> service.getTask("1"));
    }

    // Test updating the name and description of an existing task.
    
    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.updateTask("1", "UpdatedTask", "This is updated task");
        Task task = service.getTask("1");
        assertEquals("UpdatedTask", task.getName());
        assertEquals("This is updated task", task.getDescription());
    }

    // Test updating a task that doesn't exist in the service.
    
    @Test
    public void testUpdateNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTask("1", "UpdatedTask", "This is updated task"));
    }
    
    // Test adding a task with null values for ID, name, and description.
    
    @Test
    public void testAddNullTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.addTask(null, null, null));
    }
    
    // Test updating a task with empty strings for ID, name, and description.

    @Test
    public void testUpdateEmptyTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTask("", "", ""));
    }
    
    // Test deleting a task that doesn't exist in the service.

    @Test
    public void testDeleteNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("NonExistentId"));
    }

    // Test adding multiple tasks and then retrieving them by their IDs.
    
    @Test
    public void testAddAndGetMultipleTasks() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.addTask("2", "Task2", "This is task 2");
        Task task1 = service.getTask("1");
        Task task2 = service.getTask("2");
        assertNotNull(task1);
        assertNotNull(task2);
        assertEquals("1", task1.getId());
        assertEquals("2", task2.getId());
    }
    
    // Test updating a task multiple times.

    @Test
    public void testUpdateUpdatedTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.updateTask("1", "UpdatedTask", "This is updated task");
        service.updateTask("1", "UpdatedTaskAgain", "This is updated task again");
        Task task = service.getTask("1");
        assertEquals("UpdatedTaskAgain", task.getName());
        assertEquals("This is updated task again", task.getDescription());
    }
}