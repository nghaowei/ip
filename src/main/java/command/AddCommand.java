package command;

import exception.GenieweenieException;
import storage.Storage;
import task.Deadline;
import task.Events;
import task.Task;
import task.TaskList;
import task.Todo;
import ui.Ui;


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
    public String execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException {
        Task task;

        if (description.startsWith("todo ")) {
            String desc = description.substring(5).trim();
            if (desc.isEmpty()) {
                throw new GenieweenieException("Todo description cannot be empty!");
            }
            task = new Todo(desc);

        } else if (description.startsWith("deadline ")) {
            // Example: "deadline submit report /by 2025-09-05"
            String[] parts = description.substring(9).split(" /by ", 2);
            if (parts.length < 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                throw new GenieweenieException("Deadline must have a description and /by date!");
            }
            task = new Deadline(parts[0].trim(), parts[1].trim());

        } else if (description.startsWith("event ")) {
            // Example: "event team meeting /at 2025-09-05 14:00"
            String[] parts = description.substring(6).split(" /at ", 2);
            if (parts.length < 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                throw new GenieweenieException("Event must have a description and /at date/time!");
            }
            task = new Events(description, parts[0].trim(), parts[1].trim());

        } else {
            throw new GenieweenieException("Unknown task type! Use todo, deadline, or event.");
        }

        // Add to task list
        tasks.add(task);
        // Save message in response
        response = ui.showAddTask(task, tasks.size());

        // Save tasks
        try {
            storage.save(tasks.getTasks().toArray(new Task[0]));
        } catch (Exception e) {
            throw new GenieweenieException("Failed to save task: " + e.getMessage());
        }

        // Return message for GUI & CLI
        return ui.showAddTask(task, tasks.size());
    }
}
