import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;

    public Deadline(String desc, String by) {
        super(desc);
        this.by = LocalDate.parse(by); // expects yyyy-mm-dd
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()
                + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String toSaveFormat() {
        return "D | " + (isDone() ? "1" : "0") + " | "
                + getName() + " | " + by;
    }

    public static Deadline fromSaveFormat(String[] parts) {
        // parts: [ "D", "0/1", description, yyyy-mm-dd ]
        return new Deadline(parts[2], parts[3]);
    }
}