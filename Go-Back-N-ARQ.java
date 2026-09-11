import java.util.Scanner;

public class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();

        System.out.print("Enter window size: ");
        int w = sc.nextInt();

        System.out.print("Enter frame number to lose: ");
        int lost = sc.nextInt();

        int i = 1;

        while (i <= n) {
            System.out.println("\nSending frames:");

            int end = Math.min(i + w - 1, n);

            for (int j = i; j <= end; j++) {
                System.out.println("Sending Frame " + j);
            }

            if (lost >= i && lost <= end) {
                System.out.println("Frame " + lost + " lost!");
                System.out.println("Timeout occurred.");
                System.out.println("Go-Back-N: Retransmitting from Frame " + lost);

                for (int j = lost; j <= end; j++) {
                    System.out.println("Retransmitting Frame " + j);
                }

                lost = -1;
                i = end + 1;
            } else {
                System.out.println("All frames acknowledged.");
                i = end + 1;
            }
        }

        System.out.println("\nAll frames transmitted successfully.");
        sc.close();
    }
}
