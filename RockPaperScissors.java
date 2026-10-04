import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== ROCK PAPER SCISSORS ===");

        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");

        System.out.print("Enter your choice (1-3): ");
        int userChoice = scanner.nextInt();

        // Check valid input
        if (userChoice < 1 || userChoice > 3) {
            System.out.println("Invalid choice!");
            scanner.close();
            return;
        }

        // Computer generates 1, 2 or 3
        int computerChoice = random.nextInt(3) + 1;

        System.out.println();

        System.out.println("You chose: "
                + getChoice(userChoice));

        System.out.println("Computer chose: "
                + getChoice(computerChoice));

        // Check winner
        if (userChoice == computerChoice) {

            System.out.println("Result: DRAW!");

        } else if (
                (userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)
        ) {

            System.out.println("Result: YOU WIN!");

        } else {

            System.out.println("Result: COMPUTER WINS!");
        }

        scanner.close();
    }

    // Convert number into Rock, Paper or Scissors
    public static String getChoice(int choice) {

        switch (choice) {

            case 1:
                return "Rock";

            case 2:
                return "Paper";

            case 3:
                return "Scissors";

            default:
                return "Invalid";
        }
    }
}
