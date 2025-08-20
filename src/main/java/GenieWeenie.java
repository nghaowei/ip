import java.util.Scanner;

public class GenieWeenie {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String lineBorder = "____________________________________________________________";
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

            System.out.println(lineBorder);
            System.out.println(" " +input); // Echo
            System.out.println(lineBorder);
        }

        sc.close();
    }
}
