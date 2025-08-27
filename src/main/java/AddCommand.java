import java.io.IOException;

public class AddCommand implements Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.add(task);
        ui.showAddTask(task, tasks.size());

        try {
            storage.save(tasks);
        } catch (IOException e) {
            ui.showError("Error saving tasks: " + e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
