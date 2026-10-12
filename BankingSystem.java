
import java.util.*;

class BankAccount {
    String name;
    int accountNumber;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    BankAccount(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        balance = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        balance += amount;
        history.add("Deposited: Rs. " + amount);
        System.out.println("Deposit successful!");
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            history.add("Withdrawn: Rs. " + amount);
            System.out.println("Withdrawal successful!");
        }
    }

    void checkBalance() {
        System.out.printf("Balance: Rs. %.2f%n", balance);
    }

    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : history) {
                System.out.println(transaction);
            }
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANKING SYSTEM =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        BankAccount account =
            new BankAccount(name, accountNumber);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Amount: ");
                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showHistory();
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
