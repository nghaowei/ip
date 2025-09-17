package command;

import exception.GenieweenieException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents the exit command.
 */
public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks) {    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        // Store goodbye message in response
        response = ui.showGoodbye();

        // Save tasks to storage
        try {
            storage.save(tasks.getTasks().toArray(new task.Task[0]));
        } catch (Exception e) {
            throw new GenieweenieException("Failed to save tasks on exit: " + e.getMessage());
        }

        // Return the stored response
        return response;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
