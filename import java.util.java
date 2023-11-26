import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        int sum = number1 + number2;

        System.out.println("The sum of " + number1 + " and " + number2 + " is " + sum);

        // Close the scanner to free resources
        scanner.close();
    }
}
