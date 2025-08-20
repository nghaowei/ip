public class Task {
    private boolean taskDone;
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
        this.taskDone = false;
    }

    public void markTask() {
        taskDone = true;
    }

    public void unmarkTask() {
        taskDone = false;
    }

    @Override
    public String toString() {
        String markSymbol = taskDone ? "X" : " ";
        return ("[" + markSymbol + "] " + taskName);
    }
}
