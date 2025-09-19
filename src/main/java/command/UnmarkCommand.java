package command;

import exception.GenieweenieException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents a command to unmark a task as not done.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructs an UnmarkCommand with the given task index.
     *
     * @param index the 1-based index of the task to unmark
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) {
        // Not used with this version
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        try {
            tasks.getTask(index - 1).markAsNotDone();
            response = "OK, I've marked this task as not done yet:\n  "
                    + tasks.getTask(index - 1);
            return response;
        } catch (IndexOutOfBoundsException e) {
            throw new GenieweenieException("Invalid task number: " + index);
        }
    }
}
