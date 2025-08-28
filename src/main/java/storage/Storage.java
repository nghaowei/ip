package storage;

import exception.GenieweenieException;
import parser.Parser;
import task.Task;
import task.TaskList;

import java.io.*;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    // Load a task.TaskList.task.TaskList instead of ArrayList
    public TaskList load() throws GenieweenieException {
        TaskList tasks = new TaskList();
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                return tasks; // empty task.TaskList.task.TaskList if file doesn't exist
            }
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                Task t = Parser.parseSavedTask(line);
                tasks.add(t);
            }
            br.close();
        } catch (IOException e) {
            throw new GenieweenieException("Error reading file: " + e.getMessage());
        }
        return tasks;
    }

    // Save a task.TaskList.task.TaskList
    public void save(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task t : tasks.getTasks()) {
            fw.write(t.toSaveFormat() + System.lineSeparator());
        }
        fw.close();
    }
}
