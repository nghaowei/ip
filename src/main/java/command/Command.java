package command;


import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.GenieweenieException;


/**
 * Represents a user command.
 */
public abstract class Command {


    /**
     * Executes the command.
     *
     * @param tasks the TaskList
     * @param ui the UI
     * @param storage the storage handler
     * @throws GenieweenieException if execution fails
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException;


    /**
     * Checks if command is an exit command.
     *
     * @return true if exit command
     */
    public boolean isExit() {
        return false;
    }
}