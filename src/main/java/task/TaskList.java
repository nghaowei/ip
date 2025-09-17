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

    public void add(Task task) {
        assert task != null : "Task to add should not be null";
        tasks.add(task);
    }

    public Task getTask(int index) {
        assert index >= 0 && index < tasks.size() : "Index " + index + " is invalid";
        return tasks.get(index);
    }

    public Task get(int index) {
        return tasks.get(index);
    }

    public Task deleteTask(int index) {
        assert index >= 0 && index < tasks.size() : "Index " + index + " is invalid for delete";
        return tasks.remove(index);
    }

    public int size() {
        return tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

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

    /**
     * Marks the task at the given index as done.
     *
     * @param index index of the task (0-based)
     */
    public void markTask(int index) {
        Task task = getTask(index);
        task.markAsDone();
    }

    /**
     * Unmarks the task at the given index (sets as not done).
     *
     * @param index index of the task (0-based)
     */
    public void unmarkTask(int index) {
        Task task = getTask(index);
        task.markAsNotDone();
    }
}
