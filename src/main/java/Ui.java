import java.util.Scanner;

public class Ui {

    private final String line = "____________________________________________________________";

    public void showLine() {
        System.out.println(line);
    }

    public void showWelcome() {
        showLine();
        System.out.println(" Hello! I'm GenieWeenie");
        System.out.println(" What can I do for you?");
        showLine();
    }

    public void showGoodbye() {
        System.out.println(line);
        System.out.println("F-off. Hope to never see you again!");
        System.out.println(line);
    }

    public void showAddTask(Task task, int totalTasks) {
        System.out.println(line);
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + totalTasks + " tasks in the list.");
        System.out.println(line);
    }

    public void showError(String message) {
        System.out.println(line);
        System.out.println("Error: " + message);
        System.out.println(line);
    }

    public String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showLoadingError() {
        System.out.println(line);
        System.out.println("Error loading tasks! Starting with an empty list.");
        System.out.println(line);
    }
}
