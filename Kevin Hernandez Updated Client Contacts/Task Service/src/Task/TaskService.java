/**
 * File: TaskService.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This file defines the TaskService class, a service layer responsible for managing Task objects, which represent individual tasks with unique identifiers, names, and descriptions. 
 * The class maintains a collection of tasks, allowing for the creation, retrieval, updating, and deletion of tasks based on their unique IDs. 
 * It ensures the integrity of the task collection by preventing tasks with duplicate IDs and handling requests for non-existent tasks.
 **/

package Task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // A map to store tasks using their ID as the key.
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the service.
     * 
     * @param id          The unique identifier for the task.
     * @param name        The name of the task.
     * @param description The description of the task.
     * @return The created task.
     * @throws IllegalArgumentException if a task with the given ID already exists.
     */
    public Task addTask(String id, String name, String description) {
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate ID");
        }

        Task task = new Task(id, name, description);
        tasks.put(id, task);
        return task;
    }

    /**
     * Deletes a task from the service.
     * 
     * @param id The unique identifier of the task to be deleted.
     * @throws IllegalArgumentException if no task with the given ID exists.
     */
    public void deleteTask(String id) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        tasks.remove(id);
    }

    /**
     * Retrieves a task by its ID.
     * 
     * @param id The unique identifier of the task to be retrieved.
     * @return The task with the given ID, or null if no such task exists.
     */
    public Task getTask(String id) {
        return tasks.get(id);
    }

    /**
     * Updates the name and description of a task.
     * 
     * @param id          The unique identifier of the task to be updated.
     * @param name        The new name for the task.
     * @param description The new description for the task.
     * @throws IllegalArgumentException if no task with the given ID exists.
     */
    public void updateTask(String id, String name, String description) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        Task task = tasks.get(id);
        task.setName(name);
        task.setDescription(description);
    }
}
