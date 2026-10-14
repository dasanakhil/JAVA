
import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] movies = {
            "Salaar", "Kalki 2898 AD",
            "Pushpa 2", "RRR"
        };

        int[] prices = {200, 250, 300, 180};
        int[] seats = {50, 40, 30, 60};

        int bookedMovie = -1;
        int bookedTickets = 0;
        int totalAmount = 0;

        while (true) {

            System.out.println("\n===== MOVIE TICKET BOOKING =====");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Movies:");

                    for (int i = 0; i < movies.length; i++) {
                        System.out.println(
                            (i + 1) + ". " + movies[i] +
                            " | Rs." + prices[i] +
                            " | Seats: " + seats[i]
                        );
                    }
                    break;

                case 2:
                    if (bookedMovie != -1) {
                        System.out.println(
                            "Cancel your existing booking first!"
                        );
                        break;
                    }

                    System.out.println("\nSelect Movie:");

                    for (int i = 0; i < movies.length; i++) {
                        System.out.println(
                            (i + 1) + ". " + movies[i]
                        );
                    }

                    System.out.print("Movie Number: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                        break;
                    }
                    int movie = sc.nextInt() - 1;

                    if (movie < 0 || movie >= movies.length) {
                        System.out.println("Invalid movie!");
                        break;
                    }

                    System.out.print("Number of Tickets: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                        break;
                    }
                    int tickets = sc.nextInt();

                    if (tickets <= 0 || tickets > seats[movie]) {
                        System.out.println(
                            "Invalid quantity or insufficient seats!"
                        );
                        break;
                    }

                    bookedMovie = movie;
                    bookedTickets = tickets;
                    totalAmount = tickets * prices[movie];

                    seats[movie] -= tickets;

                    System.out.println("Booking Successful!");
                    System.out.println(
                        "Total Amount: Rs." + totalAmount
                    );
                    break;

                case 3:
                    if (bookedMovie == -1) {
                        System.out.println("No booking found!");
                    } else {
                        System.out.println("\n===== YOUR BOOKING =====");
                        System.out.println(
                            "Movie: " + movies[bookedMovie]
                        );
                        System.out.println(
                            "Tickets: " + bookedTickets
                        );
                        System.out.println(
                            "Total: Rs." + totalAmount
                        );
                    }
                    break;

                case 4:
                    if (bookedMovie == -1) {
                        System.out.println("No booking to cancel!");
                    } else {
                        seats[bookedMovie] += bookedTickets;

                        bookedMovie = -1;
                        bookedTickets = 0;
                        totalAmount = 0;

                        System.out.println(
                            "Booking Cancelled Successfully!"
                        );
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
