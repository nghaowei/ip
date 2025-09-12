package task;

import java.util.ArrayList;

/**
 * Represents a list of tasks.
 * Provides operations to add, retrieve, delete, and inspect tasks.
 */
public class TaskList {

    /** List storing the tasks. */
    private final ArrayList<Task> tasks;

    /**
     * Creates a task list initialized with an existing list of tasks.
     *
     * @param tasks the initial tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }



    /**
     * Adds a task to the list.
     *
     * @param task the task to add
     */
    public void add(Task task) {
        assert task != null : "Task to add should not be null";
        tasks.add(task);
    }

    /**
     * Returns the task at the given index (0-based).
     *
     * @param index the index of the task
     * @return the task at the index
     */
    public Task getTask(int index) {
        assert index >= 0 && index < tasks.size() : "Index " + index + " is invalid";
        return tasks.get(index);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Removes and returns the task at the given index.
     *
     * @param index the index of the task
     * @return the removed task
     */
    public Task deleteTask(int index) {
        assert index >= 0 && index < tasks.size() : "Index " + index + " is invalid for delete";
        return tasks.remove(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return the number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns the underlying list of tasks.
     *
     * @return the list of tasks
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    /**
     * Finds and returns a list of tasks that contain the given keyword.
     *
     * @param keyword The keyword to search for.
     * @return A list of matching tasks.
     */
    public ArrayList<Task> findTasks(String keyword) {
        assert keyword != null && !keyword.isEmpty() : "Keyword should not be null or empty";
        ArrayList<Task> matching = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matching.add(task);
            }
        }
        return matching;
    }
}
