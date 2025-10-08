/**
 * @Filename-Main.java
 * @Description- for taking user input and calling String functions
 * @Author-Ayushi Shukla
 * 
 */

import java.util.*;
public class Main{
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        MyString obj = new MyString();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("\nOperations:");
        System.out.println("1. Append");
        System.out.println("2. Count Words");
        System.out.println("3. Replace");
        System.out.println("4. Palindrome");
        System.out.println("5. Splice");
        System.out.println("6. Split");
        System.out.println("7. Max Repeating Character");
        System.out.println("8. Sort");
        System.out.println("9. Shift");
        System.out.println("10. Reverse");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

switch (choice) {
            case 1:
                str = obj.appendString(sc, str);
                System.out.println("Result: " + str);
                break;

            case 2:
                int length=obj.countWords(str);
                System.out.println("Result: " + length);
                break;

            case 3:
                System.out.print("Enter old character: ");
                char oldCh = sc.next().charAt(0);
                System.out.print("Enter new character: ");
                char newCh = sc.next().charAt(0);
                String replaceString=obj.replace(str, oldCh, newCh);
                System.out.println("Result: " + replaceString);
                break;

            case 4:
                boolean isPalindrome=obj.checkPalindrome(str);
                System.out.println(isPalindrome? "Palindrome" :" Not a Palindrome");
                break;

            case 5:
                str = obj.spliceString(sc, str);
                System.out.println("After splice: " + str);
                break;

            case 6:
               String SplitWords= obj.splitLetters(str);
               System.out.println("After Splitting : " +SplitWords);
                break;

            case 7:
                char maxChar=obj.maxRepeatingChar(str);
                System.out.println("Max repeating character: " + maxChar);
                break;

            case 8:
                str = obj.sortString(str);
                System.out.println("Sorted: " + str);
                break;

            case 9:
                str = obj.shiftString(str);
                System.out.println("After Shifting : " + str);
                break;

            case 10:
                String rev=obj.reverseString(str);
                System.out.println("Reversed: " + rev);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}