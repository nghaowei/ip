package storage;


/**
 * Loads tasks from file.
 *
 * @return array of tasks
 * @throws IOException if file cannot be read
 */
public Task[] load() throws IOException {
    File file = new File(filePath);
    if (!file.exists()) {
        file.createNewFile();
    }


    Scanner sc = new Scanner(file);
    Task[] tasks = new Task[100];
    int index = 0;


    while (sc.hasNextLine()) {
        String[] parts = sc.nextLine().split(" | ");
        Task t;
        switch (parts[0]) {
            case "T":
                t = new Todo(parts[2]);
                break;
            case "D":
                t = new Deadline(parts[2], parts[3]);
                break;
            case "E":
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