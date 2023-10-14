package Task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    public Task addTask(String id, String name, String description) {
        if (tasks.containsKey(id)) {
            throw new IllegalArgumentException("Duplicate ID");
        }

        Task task = new Task(id, name, description);
        tasks.put(id, task);
        return task;
    }

    public void deleteTask(String id) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        tasks.remove(id);
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }

    public void updateTask(String id, String name, String description) {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
        Task task = tasks.get(id);
        task.setName(name);
        task.setDescription(description);
    }
}

