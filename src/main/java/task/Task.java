package task;


/**
 * Represents a general Task with a description and completion status.
 */
public class Task {


    /** The description of the task. */
    protected String description;


    /** Whether the task is done. */
    protected boolean isDone;


    /**
     * Creates a new Task.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks this task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Returns status icon.
     *
     * @return "X" if done, otherwise a space
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }


    /**
     * Gets the description of the task.
     *
     * @return task description
     */
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
