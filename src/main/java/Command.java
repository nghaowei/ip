public interface Command {
    void execute(TaskList tasks, Ui ui, Storage storage) throws GenieweenieException;
    boolean isExit();
}