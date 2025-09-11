package task;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

/**
 * Represents a general Task with a description and completion status.
 */
public class Task {



    /** The description of the task. */
    protected String description;

    /** Whether the task is done. */
    protected boolean isDone;

    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Creates a new Task.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    // New constructor with period
    public Task(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.isDone = false;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
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
        String period = "";
        if (startDate != null && endDate != null) {
            period = " (from: " + startDate + " to: " + endDate + ")";
        }
        return "[" + getStatusIcon() + "] " + description + period;
    }

    // Getters
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    // Setters (optional)
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Checks if a date is within the task's start and end dates (inclusive).
     *
     * @param date the date to check
     * @return true if within period, false otherwise
     */
    public boolean isWithinPeriod(LocalDate date) {
        if (startDate == null || endDate == null) {
            return true; // no period restriction
        }
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }
}
