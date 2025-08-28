package task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    public void addTask_sizeIncreases() {
        TaskList list = new TaskList();
        Task t = new ToDo("do ip");
        list.addTask(t);
        assertEquals(1, list.size());
    }

    @Test
    public void getTask_returnsCorrectTask() {
        TaskList list = new TaskList();
        Task t = new ToDo("do tp");
        list.addTask(t);
        assertEquals("do tp", list.getTask(0).getName());
    }
}
