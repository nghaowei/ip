package command;

import exception.GenieweenieException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks) {
        // Not used with this version
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        try {
            Task removed = tasks.deleteTask(index - 1);
            response = "Noted. I've removed this task:\n  " + removed + "\nNow you have " + tasks.size() + " tasks in the list.";
            return response;
        } catch (IndexOutOfBoundsException e) {
            throw new GenieweenieException("Invalid task number: " + index);
        }
    }
}
