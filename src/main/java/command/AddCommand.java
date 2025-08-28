package command;


import task.TaskList;
import task.Todo;
import ui.Ui;
import storage.Storage;
import exception.GenieweenieException;


/**
 * Represents the add command.
 */
public class AddCommand extends Command {


    private final String description;


    /**
     * Creates a new AddCommand.
     *
     * @param description task description
     */
    public AddCommand(String description) {
        this.description = description;
    }


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        Todo todo = new Todo(description);
        tasks.add(todo);
        ui.showMessage("Got it. I've added this task: " + todo);
        try {
            storage.save(tasks.getTasks());
        } catch (Exception e) {
            throw new GenieweenieException("Failed to save task");
        }
    }
}