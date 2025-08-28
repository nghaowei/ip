import java.io.IOException;
import java.util.Scanner;


import command.Command;
import exception.GenieweenieException;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.Ui;


/**
 * Main application class for GenieWeenie task manager.
 */
public class GenieWeenie {


    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;


    /**
     * Creates a new GenieWeenie application.
     *
     * @param filePath file path for storage
     * @throws IOException if file cannot be loaded
     */
    public GenieWeenie(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }


    /**
     * Runs the application.
     */
    public void run() {
        ui.showWelcome();
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = in.nextLine();
            try {
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (GenieweenieException e) {
                ui.showError(e.getMessage());
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new GenieWeenie("data/genie.txt").run();
    }
}