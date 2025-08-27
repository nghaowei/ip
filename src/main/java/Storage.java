import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(ArrayList<Task> tasks) {
        try {
            File f = new File(filePath);
            f.getParentFile().mkdirs(); // create ./data if missing
            FileWriter fw = new FileWriter(f);
            for (Task t : tasks) {
                fw.write(t.toSaveFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) {
            return tasks; // start empty
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {
                Task t = Task.fromSaveFormat(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
        // haha
    }
}
