package Lab1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private TaskList tasks;
    private Task task1;
    private Task task2;

    @Test
    public void testAddTask() {
        tasks = new TaskList();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        tasks.addTask(task1);
        assertEquals(1, tasks.getTasks().size());
        assertEquals("Task 1", tasks.getTasks().getFirst().getDescription());
    }

    @Test
    public void testCompleteTask() {
        tasks = new TaskList();
        task1 = new Task("Task 1");
        tasks.addTask(task1);
        assertFalse(tasks.getTasks().getFirst().getStatus());
        task1.setStatus(true);
        assertTrue(tasks.getTasks().getFirst().getStatus());
    }

    @Test
    public void testRemoveTask(){
        tasks = new TaskList();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        tasks.addTask(task1);
        tasks.addTask(task2);
        assertEquals(2, tasks.getTasks().size());
        tasks.removeTask(task1);
        assertEquals(1, tasks.getTasks().size());
        assertEquals("Task 2", tasks.getTasks().getFirst().getDescription());
    }

    @Test
    public void testDeleteCompletedTasks(){
        tasks = new TaskList();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        tasks.addTask(task1);
        tasks.addTask(task2);
        task1.setStatus(true);
        tasks = tasks.deleteCompletedTasks(tasks);
        assertEquals(1, tasks.getTasks().size());
        assertEquals("Task 2", tasks.getTasks().getFirst().getDescription());
    }

    @Test
    public void testTaskToString(){
        task1 = new Task("Task 1");
        assertEquals("[ ]Task 1", task1.toString());
        task1.setStatus(true);
        assertEquals("[✓]Task 1", task1.toString());
    }

    @Test
    public void testGetBytes(){
        tasks = new TaskList();
        task1 = new Task("Task 1");
        task2 = new Task("Task 2");
        tasks.addTask(task1);
        tasks.addTask(task2);
        task1.setStatus(true);
        String expected = "true;Task 1\nfalse;Task 2\n";
        assertArrayEquals(expected.getBytes(), tasks.getBytes());
    }

    @Test
    public void testGetAndSetDescription(){
        task1 = new Task("Task 1");
        assertEquals("Task 1", task1.getDescription());
        assertFalse(task1.getStatus());
        task1.setStatus(true);
        assertTrue(task1.getStatus());
    }


}