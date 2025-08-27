public class Task {
    private boolean taskDone;
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
        this.taskDone = false;
    }

    public void markTask() { taskDone = true; }
    public void unmarkTask() { taskDone = false; }
    public boolean isDone() { return taskDone; }
    public String getName() { return taskName; }

    @Override
    public String toString() {
        String markSymbol = taskDone ? "X" : " ";
        return ("[" + markSymbol + "] " + taskName);
    }

    public String toSaveFormat() {
        return "T | " + (taskDone ? 1 : 0) + " | " + taskName;
    }

    public static Task fromSaveFormat(String line) {
        try {
            String[] parts = line.split(" \\| ");
            String type = parts[0];
            boolean done = parts[1].equals("1");
            String desc = parts[2];
            Task t;
            switch (type) {
                case "T": t = new ToDo(desc); break;
                case "D": t = new Deadline(desc, parts[3]); break;
                case "E": t = new Events(desc, parts[3], parts[4]); break;
                default: return null;
            }
            if (done) t.markTask();
            return t;
        } catch (Exception e) {
            System.out.println("Corrupted line ignored: " + line);
            return null;
        }
    }
}
