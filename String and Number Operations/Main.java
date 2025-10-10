/**
 * @Filename-Main.java
 * @Description- Menu driven program for String and Number operations
 * @Author- Ayushi Shukla
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyString sObj = new MyString();
        MyNumber nObj = new MyNumber();

        int choice;
        do {
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
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // STRING
                case 1 -> {
                    System.out.print("Enter a string: ");
                    String s = sc.nextLine();
                    System.out.println("Count: " + sObj.countUniquePalindromes(s));
                }
                case 2 -> {
                    System.out.print("Enter snake_case string: ");
                    String s = sc.nextLine();
                    System.out.println("camelCase: " + sObj.snakeToCamel(s));
                }
                case 3 -> {
                    System.out.print("Enter a string: ");
                    String s = sc.nextLine();
                    System.out.println("Consonants: " + sObj.countConsonants(s));
                }
                case 4 -> {
                    System.out.print("Enter encoded string (a1b4c2): ");
                    String s = sc.nextLine();
                    System.out.println("Expanded: " + sObj.expand(s));
                }
                case 5 -> {
                    System.out.print("Enter string: ");
                    String s = sc.nextLine();
                    System.out.println("Compressed: " + sObj.compress(s));
                }
                case 6 -> {
                    System.out.print("Enter string: ");
                    String s = sc.nextLine();
                    System.out.println("Longest substring length: " + sObj.longestUniqueSubstring(s));
                }

                // NUMBER
                case 7 -> {
                    System.out.print("Enter n: ");
                    int n = sc.nextInt();
                    System.out.println("Fibonacci: " + nObj.fibonacci(n));
                }
                case 8 -> {
                    System.out.print("Enter binary: ");
                    String bin = sc.nextLine();
                    System.out.println("Decimal: " + nObj.binaryToDecimal(bin));
                }
                case 9 -> {
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    System.out.println(nObj.isPrime(num) ? "Prime" : "Not Prime");
                }
                case 10 -> {
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    System.out.println("In Words: " + nObj.numberToWords(num));
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
