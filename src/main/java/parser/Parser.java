package parser;

import command.AddCommand;
import command.Command;
import command.ExitCommand;
import exception.GenieweenieException;
import task.Deadline;
import task.Events;
import task.Task;
import task.ToDo;

public class Parser {

    public static Command parse(String fullCommand) throws GenieweenieException {
        String trimmed = fullCommand.trim();

        if (trimmed.equalsIgnoreCase("bye")) {
            return new ExitCommand();
        } else if (trimmed.startsWith("todo ")) {
            Task t = new ToDo(trimmed.substring(5));
            return new AddCommand(t);
        } else if (trimmed.startsWith("deadline ")) {
            String[] parts = trimmed.substring(9).split("/by");
            if (parts.length < 2) throw new GenieweenieException("task.Deadline format: deadline <desc> /by <date>");
            Task t = new Deadline(parts[0].trim(), parts[1].trim());
            return new AddCommand(t);
        } else if (trimmed.startsWith("event ")) {
            String[] parts = trimmed.substring(6).split("/from|/to");
            if (parts.length < 3) throw new GenieweenieException("Event format: event <desc> /from <start> /to <end>");
            Task t = new Events(parts[0].trim(), parts[1].trim(), parts[2].trim());
            return new AddCommand(t);
        } else {
            throw new GenieweenieException("Unknown command: " + fullCommand);
        }
    }

    public static Task parseSavedTask(String line) throws GenieweenieException {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean done = parts[1].equals("1");
            String desc = parts[2];
            Task t;

            switch (type) {
                case "T":
                    t = new ToDo(desc);
                    break;
                case "D":
                    t = new Deadline(desc, parts[3]); // yyyy-mm-dd
                    break;
                case "E":
                    t = new Events(desc, parts[3], parts[4]);
                    break;
                default:
                    throw new GenieweenieException("Unknown task type: " + type);
            }

            if (done) t.markTask();
            return t;

        } catch (Exception e) {
            throw new GenieweenieException("Corrupted line in save file: " + line);
        }
    }
}
