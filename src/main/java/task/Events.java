package task;


/**
 * Represents an Event task with a start and end time.
 */
public class Events extends Task {


    private final String start;
    private final String end;


    /**
     * Creates a new Event task.
     *
     * @param description description of the event
     * @param start start time
     * @param end end time
     */
    public Events(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }


    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}