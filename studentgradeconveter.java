import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get student name
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        // Get marks for 5 subjects
        System.out.print("Enter marks in Java: ");
        double java = sc.nextDouble();

        System.out.print("Enter marks in Web Development: ");
        double web = sc.nextDouble();

        System.out.print("Enter marks in Database: ");
        double database = sc.nextDouble();

        System.out.print("Enter marks in Mathematics: ");
        double maths = sc.nextDouble();

        System.out.print("Enter marks in English: ");
        double english = sc.nextDouble();

        // Calculate total
        double total = java + web + database + maths + english;

        // Calculate average
        double average = total / 5;

        // Calculate grade
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display result
        System.out.println("\n========== STUDENT RESULT ==========");
        System.out.println("Student Name : " + name);
        System.out.println("Total Marks  : " + total + " / 500");
        System.out.println("Average      : " + average);
        System.out.println("Grade        : " + grade);

        // Display pass/fail
        if (average >= 40) {
            System.out.println("Result       : PASS");
        } else {
            System.out.println("Result       : FAIL");
        }

        System.out.println("====================================");

        sc.close();
    }
}
