package command;


import task.TaskList;
import ui.Ui;
import storage.Storage;


/**
 * Represents the exit command.
 */
public class ExitCommand extends Command {


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showMessage("Bye. Hope to see you again soon!");
    }


    @Override
    public boolean isExit() {
        return true;
    }
}