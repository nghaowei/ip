import java.util.Scanner;
import java.util.Arrays;


public class GenieWeenie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String lineBorder = "____________________________________________________________";
        Task[] userText = new Task[100];
        int counter = 0;

        System.out.println(lineBorder);
        System.out.println(" Hello! I'm GenieWeenie");
        System.out.println(" What can I do for you?");
        System.out.println(lineBorder);

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(lineBorder);
                System.out.println("F-off. Hope to never see you again!");
                System.out.println(lineBorder);
                break;
            }

            else if (input.equalsIgnoreCase("list")) {
                System.out.println(lineBorder);
                for (int i = 0; i < counter; i++) {
                    int listCount = i + 1;
                    System.out.println(listCount + "." + userText[i]);
                }
                System.out.println(lineBorder);
            }

            else if (input.startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    userText[index].markTask();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + userText[index]);
                    System.out.println("____________________________________________________________");
                } catch (Exception e) {
                    System.out.println(" Invalid task number!");
                }
            }

            else if (input.startsWith("unmark ")) {
                try {
                    int index = Integer.parseInt(input.split(" ")[1]) - 1;
                    userText[index].unmarkTask();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + userText[index]);
                    System.out.println("____________________________________________________________");
                } catch (Exception e) {
                    System.out.println(" Invalid task number!");
                }
            }

            else if (input.startsWith("todo")) {
                String desc = input.substring(4).trim();
                if (!desc.isEmpty()) {
                    Task t = new ToDo(desc);
                    userText[counter] = t;
                    counter++;
                    printAddTask(t, counter);
                } else {
                    System.out.println(lineBorder);
                    System.out.println("OOPS!!! The description of a todo cannot be empty."); // add words
                    System.out.println(lineBorder);
                }
            }

            else if (input.startsWith("deadline")) {
                String[] parts = input.substring(8).split("/by", 2);
                String desc = parts[0].trim();
                if (!desc.isEmpty()) {
                    Task t = new ToDo(desc);
                    userText[counter] = t;
                    counter++;
                    printAddTask(t, counter);
                }
                String deadline = parts.length > 1 ? parts[1].trim() : "unspecified";
                Task t = new Deadlines(desc, deadline);
                userText[counter] = t;
                counter++;
                printAddTask(t, counter);
            }

            else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split("/from|/to");
                if (parts.length < 3) {
                    System.out.println(" Invalid event format! Use: event <desc> /from <start> /to <end>");
                    continue;
                }
                String desc = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                Task t = new Events(desc, from, to);
                userText[counter] = t;
                counter++;
                printAddTask(t, counter);
            }

            else {
                System.out.println(lineBorder);
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-("); // add words
                System.out.println(lineBorder);
//                userText[counter] = new Task(input);
//                counter++;
            }
        }

        sc.close();
    }

    private static void printAddTask(Task t, int counter) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + t);
        System.out.println(" Now you have " + counter + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
}
