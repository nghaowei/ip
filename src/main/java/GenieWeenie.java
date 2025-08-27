import java.util.ArrayList;
import java.util.Scanner;

public class GenieWeenie {
    public static void main(String[] args) {
        Storage storage = new Storage("./data/duke.txt");
        ArrayList<Task> tasks = storage.load();
        Scanner sc = new Scanner(System.in);
        String lineBorder = "____________________________________________________________";

        System.out.println(lineBorder);
        System.out.println(" Hello! I'm GenieWeenie");
        System.out.println(" What can I do for you?");
        System.out.println(lineBorder);

        while (true) {
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(lineBorder);
                System.out.println("F-off. Hope to never see you again!");
                System.out.println(lineBorder);
                break;
            }

            else if (input.equalsIgnoreCase("list")) {
                System.out.println(lineBorder);
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + "." + tasks.get(i));
                }
                System.out.println(lineBorder);
            }

            else if (input.startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    tasks.get(index).markTask();
                    System.out.println(lineBorder);
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks.get(index));
                    System.out.println(lineBorder);
                    storage.save(tasks);
                } catch (Exception e) {
                    System.out.println(lineBorder);
                    System.out.println(" Invalid task number!");
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("unmark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    tasks.get(index).unmarkTask();
                    System.out.println(lineBorder);
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks.get(index));
                    System.out.println(lineBorder);
                    storage.save(tasks);
                } catch (Exception e) {
                    System.out.println(lineBorder);
                    System.out.println(" Invalid task number!");
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("delete ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    Task removed = tasks.remove(index);
                    System.out.println(lineBorder);
                    System.out.println(" Noted. I've removed this task:");
                    System.out.println("   " + removed);
                    System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                    System.out.println(lineBorder);
                    storage.save(tasks);
                } catch (Exception e) {
                    System.out.println(lineBorder);
                    System.out.println(" Invalid task number!");
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("todo")) {
                String desc = input.substring(4).trim();
                if (!desc.isEmpty()) {
                    Task t = new ToDo(desc);
                    tasks.add(t);
                    printAddTask(t, tasks.size(), lineBorder);
                    storage.save(tasks);
                } else {
                    System.out.println(lineBorder);
                    System.out.println("OOPS!!! The description of a todo cannot be empty.");
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("deadline")) {
                String[] parts = input.substring(8).split("/by", 2);
                String desc = parts[0].trim();
                String deadline = parts.length > 1 ? parts[1].trim() : "unspecified";
                if (!desc.isEmpty()) {
                    Task t = new Deadline(desc, deadline);
                    tasks.add(t);
                    printAddTask(t, tasks.size(), lineBorder);
                    storage.save(tasks);
                } else {
                    System.out.println(lineBorder);
                    System.out.println("OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split("/from|/to");
                if (parts.length < 3) {
                    System.out.println(lineBorder);
                    System.out.println(" Invalid event format! Use: event <desc> /from <start> /to <end>");
                    System.out.println(lineBorder);
                    continue;
                }
                String desc = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                Task t = new Events(desc, from, to);
                tasks.add(t);
                printAddTask(t, tasks.size(), lineBorder);
                storage.save(tasks);
            }

            else {
                System.out.println(lineBorder);
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println(lineBorder);
            }
        }

        sc.close();
    }

    private static void printAddTask(Task t, int count, String border) {
        System.out.println(border);
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + t);
        System.out.println(" Now you have " + count + " tasks in the list.");
        System.out.println(border);
    }
}
