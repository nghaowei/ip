import java.util.Scanner;
import java.util.Arrays;


public class GenieWeenie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String lineBorder = "____________________________________________________________";
        String[] userText = new String[100];
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
            else {
                System.out.println(lineBorder);
                System.out.println("added: " + input); // add words
                System.out.println(lineBorder);
                userText[counter] = input;
                counter++;
            }
        }

        sc.close();
    }
}
