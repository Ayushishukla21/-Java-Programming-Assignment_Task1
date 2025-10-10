/**
 * @Filename-Main.java
 * @Description-For taking user input and calling string functions
 * @Author-Ayushi Shukla
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyString stringOperations = new MyString();
        MyNumber numberOperations = new MyNumber();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== MENU ====");
            System.out.println("String Operations:");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Snake to Camel Case");
            System.out.println("3. Count Consonants");
            System.out.println("4. Expand Encoded String");
            System.out.println("5. Compress String");
            System.out.println("6. Longest Unique Substring");
            System.out.println("\nNumber Operations:");
            System.out.println("7. Fibonacci");
            System.out.println("8. Binary to Decimal");
            System.out.println("9. Prime Check");
            System.out.println("10. Number to Words");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    System.out.println("Unique palindromes count: " + stringOperations.countUniquePalindromes(inputString));
                }
                case 2 -> {
                    System.out.print("Enter snake_case string: ");
                    String inputString = scanner.nextLine();
                    System.out.println("camelCase: " + stringOperations.snakeToCamel(inputString));
                }
                case 3 -> {
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    System.out.println("Consonant count: " + stringOperations.countConsonants(inputString));
                }
                case 4 -> {
                    System.out.print("Enter encoded string (e.g., a1b4c2): ");
                    String inputString = scanner.nextLine();
                    System.out.println("Expanded: " + stringOperations.expand(inputString));
                }
                case 5 -> {
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    System.out.println("Compressed: " + stringOperations.compress(inputString));
                }
                case 6 -> {
                    System.out.print("Enter a string: ");
                    String inputString = scanner.nextLine();
                    System.out.println("Length of longest unique substring: " + stringOperations.longestUniqueSubstring(inputString));
                }
                case 7 -> {
                    System.out.print("Enter the number of Fibonacci terms: ");
                    int number = scanner.nextInt();
                    if (number <= 0) {
                        System.out.println("Please enter a positive number.");
                    } else {
                        System.out.print("Fibonacci Series: ");
                        for (int index = 0; index < number; index++) {
                            System.out.print(numberOperations.fibonacci(index) + " ");
                        }
                        System.out.println();
                    }
                }
                case 8 -> {
                    System.out.print("Enter binary string: ");
                    String binaryString = scanner.nextLine();
                    try {
                        System.out.println("Decimal: " + numberOperations.binaryToDecimal(binaryString));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 9 -> {
                    System.out.print("Enter number: ");
                    int number = scanner.nextInt();
                    System.out.println(numberOperations.isPrime(number) ? "Prime" : "Not Prime");
                }
                case 10 -> {
                    System.out.print("Enter number: ");
                    int number = scanner.nextInt();
                    System.out.println("In Words: " + numberOperations.numberToWords(number));
                }
                case 0 -> {
                    System.out.print("Are you sure you want to exit? (y/n): ");
                    String confirm = scanner.nextLine().toLowerCase();
                    if (confirm.equals("y") || confirm.equals("yes")) {
                        exit = true;
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Returning to menu...");
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
