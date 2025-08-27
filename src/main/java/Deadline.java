import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected LocalDate by;
    private static final LocalDate TODAY = LocalDate.now(); // constant for today

    public Deadline(String desc, String by) throws GenieweenieException {
        super(desc);
        try {
            LocalDate parsedDate = LocalDate.parse(by); // expects yyyy-MM-dd
            if (parsedDate.isBefore(TODAY)) {
                throw new GenieweenieException("Deadline cannot be before today ("
                        + TODAY.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ").");
            }
            this.by = parsedDate;
        } catch (DateTimeParseException e) {
            throw new GenieweenieException("Invalid date format. Use yyyy-MM-dd, e.g., 2025-08-28.");
        }
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
}
