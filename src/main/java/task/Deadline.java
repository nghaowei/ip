package task;


/**
 * Represents a Deadline task with a due date.
 */
public class Deadline extends Task {


    private final String by;


    /**
     * Creates a new Deadline task.
     *
     * @param description description of the deadline
     * @param by due date
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}