import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import task.TaskList;
import task.Todo;

/**
 * Additional tests for {@link task.TaskList}.
 */
public class TaskListTestExtras {

    /**
     * Tests that {@link TaskList#findTasks(String)} returns
     * only the tasks whose descriptions contain the given keyword.
     */
    @Test
    public void findTasksMatchingKeywordReturnsCorrectTasks() {
        TaskList tasks = new TaskList();
        tasks.add(new Todo("Read book"));
        tasks.add(new Todo("Write code"));
        tasks.add(new Todo("Read notes"));

        assertEquals(2, tasks.findTasks("Read").size());
    }

    /**
     * Tests that {@link TaskList#markTask(int)} marks a task as done
     * and {@link TaskList#unmarkTask(int)} correctly resets it to not done.
     */
    @Test
    public void markAndUnmarkTaskChangesStatus() {
        TaskList tasks = new TaskList();
        Todo t = new Todo("Finish homework");
        tasks.add(t);

        tasks.markTask(0);
        assertTrue(tasks.getTask(0).isDone());

        tasks.unmarkTask(0);
        assertTrue(!tasks.getTask(0).isDone());
    }
}
