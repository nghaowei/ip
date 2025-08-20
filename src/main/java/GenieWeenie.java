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
            else {
                System.out.println(lineBorder);
                System.out.println("added: " + input); // add words
                System.out.println(lineBorder);
                userText[counter] = new Task(input);
                counter++;
            }
        }

        sc.close();
    }
}
