package Task;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddAndGetTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        Task task = service.getTask("1");
        assertNotNull(task);
        assertEquals("1", task.getId());
    }

    @Test
    public void testAddDuplicateTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        assertThrows(IllegalArgumentException.class, () -> service.addTask("1", "Task2", "This is task 2"));
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> service.getTask("1"));
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        service.addTask("1", "Task1", "This is task 1");
        service.updateTask("1", "UpdatedTask", "This is updated task");
        Task task = service.getTask("1");
        assertEquals("UpdatedTask", task.getName());
        assertEquals("This is updated task", task.getDescription());
    }

    @Test
    public void testUpdateNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTask("1", "UpdatedTask", "This is updated task"));
    }
    @Test
    public void testAddNullTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.addTask(null, null, null));
    }

    @Test
    public void testUpdateEmptyTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTask("", "", ""));
    }

    @Test
    public void testDeleteNonExistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("NonExistentId"));
    }

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