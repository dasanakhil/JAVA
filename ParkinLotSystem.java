import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }
}

public class ParkingLotSystem {

    static ArrayList<Vehicle> parkedVehicles = new ArrayList<>();
    static final int TOTAL_SLOTS = 5;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PARKING LOT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Available Slots");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    parkVehicle(sc);
                    break;

                case 2:
                    removeVehicle(sc);
                    break;

                case 3:
                    viewVehicles();
                    break;

                case 4:
                    showAvailableSlots();
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

    // Park a vehicle
    static void parkVehicle(Scanner sc) {

        if (parkedVehicles.size() >= TOTAL_SLOTS) {
            System.out.println("Parking lot is full!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        Vehicle vehicle = new Vehicle(number, owner);

        parkedVehicles.add(vehicle);

        System.out.println("Vehicle parked successfully!");
        System.out.println("Slot Number: " + parkedVehicles.size());
    }

    // Remove a vehicle
    static void removeVehicle(Scanner sc) {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        for (Vehicle vehicle : parkedVehicles) {

            if (vehicle.vehicleNumber.equalsIgnoreCase(number)) {

                parkedVehicles.remove(vehicle);

                System.out.println("Vehicle removed successfully!");
                return;
            }
        }

        System.out.println("Vehicle not found!");
    }

    // Display all parked vehicles
    static void viewVehicles() {

        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are parked.");
            return;
        }

        System.out.println("\n--- PARKED VEHICLES ---");

        int slot = 1;

        for (Vehicle vehicle : parkedVehicles) {

            System.out.println(
                    "Slot " + slot +
                    " | Vehicle: " + vehicle.vehicleNumber +
                    " | Owner: " + vehicle.ownerName
            );

            slot++;
        }
    }

    // Show available parking slots
    static void showAvailableSlots() {

        int available =
                TOTAL_SLOTS - parkedVehicles.size();

        System.out.println(
                "Total Slots     : " + TOTAL_SLOTS
        );

        System.out.println(
                "Occupied Slots  : " + parkedVehicles.size()
        );

        System.out.println(
                "Available Slots : " + available
        );
    }
}
