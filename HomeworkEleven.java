import java.util.Scanner;

public class HomeworkEleven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter multiple numbers (type 'quit' to exit):");
        while (true) {
            try {
                System.out.print("Enter a number: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("quit"))
                    break;

                int number = Integer.parseInt(input);
                System.out.println("You entered: " + number);
            } catch (Exception e) {
                System.out.println("Invalid input: Please enter a valid integer!");
            }
        }
        scanner.close();
    }
}
