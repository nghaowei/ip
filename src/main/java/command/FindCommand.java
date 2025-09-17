package command;

import exception.GenieweenieException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks) {
        // Not used with this version
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        ArrayList<Task> matches = tasks.findTasks(keyword);
        if (matches.isEmpty()) {
            response = "No matching tasks found for: " + keyword;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Here are the matching tasks in your list:\n");
            for (int i = 0; i < matches.size(); i++) {
                sb.append((i + 1) + ". " + matches.get(i) + "\n");
            }
            response = sb.toString().trim();
        }
        return response;
    }
}
