package command;

import task.TaskList;
import ui.Ui;
import storage.Storage;
import exception.GenieweenieException;

public interface Command {
    void execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException;
    boolean isExit();
}