/**
 * File: Tast.java
 * Author: [Kevin Hernandez]
 * Date: [9/25/23]
 * Version: 1.0
 * Description: This file defines the Task class, representing a task with unique identifiers and descriptive information. 
 * Each task is characterized by three main attributes: an ID, a name, and a description. 
 * The class provides methods to retrieve and update these properties, ensuring that the values adhere to specific constraints regarding nullability and character length. 
 * Any attempt to initialize a task or modify its name or description with invalid data results in an IllegalArgumentException.
 **/

package Task;

// This class represents a Task with an ID, name, and description.
public class Task {
    // Unique identifier for the task.
    private final String id;
    // Name of the task.
    private String name;
    // Description of the task.
    private String description;

    // Constructor to initialize a new task.
    public Task(String id, String name, String description) {
        // Check if the provided data is valid. If not, throw an exception.
        if (id == null || id.length() > 10 || name == null || name.length() > 20 || description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task data");
        }
        // Assign the provided values to the class variables.
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter method to retrieve the task's ID.
    public String getId() {
        return id;
    }

    // Getter method to retrieve the task's name.
    public String getName() {
        return name;
    }

    // Setter method to update the task's name.
    public void setName(String name) {
        // Check if the provided name is valid. If not, throw an exception.
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        // Assign the provided name to the class variable.
        this.name = name;
    }

    // Getter method to retrieve the task's description.
    public String getDescription() {
        return description;
    }

    // Setter method to update the task's description.
    public void setDescription(String description) {
        // Check if the provided description is valid. If not, throw an exception.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        // Assign the provided description to the class variable.
        this.description = description;
    }

    // It attempts to set the ID, but the ID is a final variable and cannot be changed.
    // Additionally, the method returns null which might not be the intended behavior.
    public Object setId(String string) {
        // TODO Auto-generated method stub
        return null;
    }
}
