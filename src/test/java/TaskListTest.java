import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import task.Task;
import task.TaskList;
import task.Todo;

public class TaskListTest {

    @Test
    public void add_and_getTask_success() {
        TaskList list = new TaskList();
        Task t = new Todo("Write JUnit test");
        list.add(t);
        assertEquals(t, list.getTask(0));
    }

    @Test
    public void size_afterAddingTasks_success() {
        TaskList list = new TaskList();
        Task t = new Todo("Write JUnit test");
        list.add(t);
        assertEquals(1, list.size());
    }
}
