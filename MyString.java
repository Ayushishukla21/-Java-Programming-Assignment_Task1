import java.util.*;

public class MyString {

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
		
		
        if (choice == 1) str = obj.appendString(sc, str);
        else if (choice == 2) obj.countWords(str);
        else if (choice == 3) str = obj.replaceString(sc, str);
        else if (choice == 4) obj.checkPalindrome(str);
        else if (choice == 5) str = obj.spliceString(sc, str);
        else if (choice == 6) obj.splitString(str);
        else if (choice == 7) obj.maxRepeatingChar(str);
        else if (choice == 8) str = obj.sortString(str);
        else if (choice == 9) str = obj.shiftString(str);
        else if (choice == 10) obj.reverseString(str);
        else System.out.println("Invalid choice!");

        sc.close();
    }

    // 1. Append
    String appendString(Scanner sc, String str) {
        System.out.print("Enter text to append: ");
        String add = sc.nextLine();
        str += add;
        System.out.println("Result: " + str);
        return str;
    }

    // 2. Count Words
    void countWords(String str) {
        String s= str.trim();
		int count=s.length();
        System.out.println("Word count: " +count);
    }

    // 3. Replace
    String replaceString(Scanner sc, String str) {
        System.out.print("Enter text to replace: ");
        String oldTxt = sc.nextLine();
        System.out.print("Enter new text: ");
        String newTxt = sc.nextLine();
        str = str.replace(oldTxt, newTxt);
        System.out.println("After replace: " + str);
        return str;
    }

    // 4. Palindrome
    void checkPalindrome(String str) {
		
        boolean flag = true;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if (flag) 
			System.out.println("Palindrome");
        else
			System.out.println("Not a Palindrome");
    }

    // 5. Splice
    String spliceString(Scanner sc, String str) {
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String newStr = str.substring(0, start) + str.substring(end);
        System.out.println("After splice: " + newStr);
        return newStr;
    }

    // 6. Split
    void splitString(String str) {
        String[] words = str.split(" ");
        System.out.println("Split words:");
        for (String w : words) System.out.println(w);
    }

    // 7. Max Repeating Character
    void maxRepeatingChar(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) 
			freq[str.charAt(i)]++;
        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > max) {
                max = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }
        System.out.println("Max repeating character: " + maxChar);
    }

    // 8. Sort
    String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        str = new String(arr);
        System.out.println("Sorted: " + str);
        return str;
    }

    // 9. Shift
    String shiftString(String str) {
        if (str.length() > 1) 
			str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        System.out.println("Shifted: " + str);
        return str;
    }

    // 10. Reverse
    void reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--)
			rev += str.charAt(i);
        System.out.println("Reversed: " + rev);
    }
}
