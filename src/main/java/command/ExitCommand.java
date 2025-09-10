package command;


import exception.GenieweenieException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;



/**
 * Represents the exit command.
 */
public class ExitCommand extends Command {

    private Task task;

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        response = ui.showGoodbye(); // store goodbye message
        try {
            storage.save(tasks.getTasks().toArray(new task.Task[0]));
        } catch (Exception e) {
            throw new GenieweenieException("Failed to save tasks on exit: " + e.getMessage());
        }

        return ui.showGoodbye();
    }


    @Override
    public boolean isExit() {
        return true;
    }

}
