package Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertEquals("1", task.getId());
        assertEquals("Task1", task.getName());
        assertEquals("This is task 1", task.getDescription());
    }

    @Test
    public void testInvalidTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task1", "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task1", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task1", "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "This is a really long task name that is more than 20 characters", "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task1", "This is a really long task description that is more than 50 characters long"));
    }

    @Test
    public void testEdgeCaseTaskCreation() {
        assertDoesNotThrow(() -> new Task("1234567890", "ThisIsA20CharTaskName", "This is a 50 character long task description, exactly."));
    }

    @Test
    public void testBoundaryCases() {
        assertThrows(IllegalArgumentException.class, () -> new Task("", "Task1", "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "", "This is task 1"));
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task1", ""));
    }

    @Test
    public void testSetters() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName("NewTask");
        task.setDescription("This is new task");
        assertEquals("NewTask", task.getName());
        assertEquals("This is new task", task.getDescription());
    }

    @Test
    public void testInvalidSetName() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("This is a really long task name that is more than 20 characters"));
    }

    @Test
    public void testInvalidSetDescription() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This is a really long task description that is more than 50 characters long"));
    }

    @Test
    public void testImmutabilityOfId() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertThrows(UnsupportedOperationException.class, () -> task.setId("2"));
    }

    @Test
    public void testGettersAfterSetters() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName("NewTask");
        task.setDescription("This is new task");
        assertEquals("1", task.getId()); // Id should remain unchanged
        assertEquals("NewTask", task.getName());
        assertEquals("This is new task", task.getDescription());
    }

    @Test
    public void testEquality() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", "This is task 1");
        Task task3 = new Task("2", "Task2", "This is task 2");
        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
    }

    @Test
    public void testToString() {
        Task task = new Task("1", "Task1", "This is task 1");
        String expectedString = "Task{id='1', name='Task1', description='This is task 1'}";
        assertEquals(expectedString, task.toString());
    }

    @Test
    public void testHashCode() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", "This is task 1");
        assertEquals(task1.hashCode(), task2.hashCode());
    }
    @Test
    public void testNullIdInEquality() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task(null, "Task1", "This is task 1");
        assertNotEquals(task1, task2);
    }

    @Test
    public void testNullNameInEquality() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", null, "This is task 1");
        assertNotEquals(task1, task2);
    }

    @Test
    public void testNullDescriptionInEquality() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", null);
        assertNotEquals(task1, task2);
    }

    @Test
    public void testDifferentTypeInEquality() {
        Task task = new Task("1", "Task1", "This is task 1");
        String differentType = "Task1";
        assertNotEquals(task, differentType);
    }

    @Test
    public void testSameObjectEquality() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertEquals(task, task);
    }

    @Test
    public void testHashCodeConsistency() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", "This is task 1");
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("2", "Task1", "This is task 1");
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testHashCodeDistribution() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("2", "Task2", "This is task 2");
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testHashCodeCollision() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("11", "Task2", "This is task 2");
        assertNotEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    public void testHashCodePerformance() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", "This is task 1");
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            task1.hashCode();
            task2.hashCode();
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        assertTrue(duration < 1000000); // Ensure it takes less than 1ms
    }

    @Test
    public void testEqualityAfterSetters() {
        Task task1 = new Task("1", "Task1", "This is task 1");
        Task task2 = new Task("1", "Task1", "This is task 1");
        task2.setName("NewTask");
        task2.setDescription("This is new task");
        assertEquals(task1, task2);
    }


    @Test
    public void testSetIdWithValidId() {
        Task task = new Task("1", "Task1", "This is task 1");
        assertThrows(UnsupportedOperationException.class, () -> task.setId("2"));
    }

    @Test
    public void testGettersWithModifiedFields() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName("NewTask");
        task.setDescription("This is new task");
        assertEquals("1", task.getId());
        assertEquals("NewTask", task.getName());
        assertEquals("This is new task", task.getDescription());
    }

    @Test
    public void testGettersAfterSettersWithNullName() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName(null);
        task.setDescription("This is new task");
        assertEquals("1", task.getId());
        assertNull(task.getName());
        assertEquals("This is new task", task.getDescription());
    }

    @Test
    public void testGettersAfterSettersWithNullDescription() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName("NewTask");
        task.setDescription(null);
        assertEquals("1", task.getId());
        assertEquals("NewTask", task.getName());
        assertNull(task.getDescription());
    }

    @Test
    public void testToStringWithNullFields() {
        Task task = new Task(null, null, null);
        String expectedString = "Task{id='null', name='null', description='null'}";
        assertEquals(expectedString, task.toString());
    }

    @Test
    public void testToStringWithModifiedFields() {
        Task task = new Task("1", "Task1", "This is task 1");
        task.setName("NewTask");
        task.setDescription("This is new task");
        String expectedString = "Task{id='1', name='NewTask', description='This is new task'}";
        assertEquals(expectedString, task.toString());
    }
}
