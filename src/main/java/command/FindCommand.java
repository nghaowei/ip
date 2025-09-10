package command;

import exception.GenieweenieException;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents the exit command.
 */
public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        StringBuilder result = new StringBuilder();
        int index = 1;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(keyword)) {
                result.append(index).append(". ").append(tasks.get(i)).append("\n");
                index++;
            }
        }

        if (index == 1) {
            return ui.showMessage("No matching tasks found.");
        } else {
            return ui.showMessage("Here are the matching tasks in your list:\n" + result);
        }
    }

    @Override
    public boolean isExit() {
        return super.isExit();
    }
}
