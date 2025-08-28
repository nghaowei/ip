package task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /** Adds a task to the list. */
    public void add(Task task) {
        tasks.add(task);
    }

    /** Returns the task at a given index (0-based). */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /** Removes and returns a task at the given index. */
    public Task deleteTask(int index) {
        return tasks.remove(index);
    }

    /** Returns number of tasks in the list. */
    public int size() {
        return tasks.size();
    }

    /** Returns the whole underlying list. */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
