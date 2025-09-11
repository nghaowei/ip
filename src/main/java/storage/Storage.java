package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import exception.GenieweenieException;
import task.Deadline;
import task.Events;
import task.Task;
import task.Todo;

/**
 * Handles loading and saving of tasks to and from a file.
 */
public class Storage {

    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from file.
     *
     * @return array of tasks
     * @throws IOException if file cannot be read
     */
    public Task[] load() throws IOException, GenieweenieException {
        File file = new File("data/filename.txt");
        file.getParentFile().mkdirs(); // creates "data" folder if missing
        if (file.createNewFile()) {
            System.out.println("New file created: " + file.getAbsolutePath());
        }


        Scanner sc = new Scanner(file);
        Task[] tasks = new Task[100];
        int index = 0;

        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" \\| "); // note: split by " | " properly
            assert parts.length >= 3 : "Corrupted line in save file: not enough parts";

            Task t;
            switch (parts[0]) {
            case "T":
                t = new Todo(parts[2]);
                break;
            case "D":
                assert parts.length >= 4 : "Deadline entry missing fields";
                t = new Deadline(parts[2], parts[3]);
                break;
            case "E":
                assert parts.length >= 5 : "Event entry missing fields";
                t = new Events(parts[2], parts[3], parts[4]);
                break;
            default:
                continue;
            }
            if (parts[1].equals("1")) {
                t.markAsDone();
            }
            tasks[index++] = t;
        }
        sc.close();
        assert index <= tasks.length : "Task array overflowed!";
        return tasks;
    }

    /**
     * Saves tasks to file.
     *
     * @param tasks array of tasks
     * @throws IOException if file cannot be written
     */
    public void save(Task[] tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task t : tasks) {
            if (t == null) {
                break;
            }
            fw.write(t.toString() + "\n");
        }
        fw.close();
    }
}
