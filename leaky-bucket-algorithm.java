import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int capacity = sc.nextInt();

        System.out.print("Enter output rate: ");
        int rate = sc.nextInt();

        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();

        int bucket = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter size of packet " + i + ": ");
            int packet = sc.nextInt();

            if (packet > capacity) {
                System.out.println("Packet " + i + " is too large and is discarded.");
                continue;
            }

            if (bucket + packet > capacity) {
                System.out.println("Bucket overflow! Packet " + i + " is discarded.");
            } else {
                bucket += packet;
                System.out.println("Packet " + i + " added to bucket.");
            }

            if (bucket > 0) {
                int sent = Math.min(bucket, rate);
                bucket -= sent;

                System.out.println("Packets sent: " + sent);
                System.out.println("Packets remaining in bucket: " + bucket);
            }
        }

        while (bucket > 0) {
            int sent = Math.min(bucket, rate);
            bucket -= sent;

            System.out.println("\nPackets sent: " + sent);
            System.out.println("Packets remaining in bucket: " + bucket);
        }

        System.out.println("\nAll packets processed successfully.");

        sc.close();
    }
}
