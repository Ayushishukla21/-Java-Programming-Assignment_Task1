/**
 * @Filename-Main.java
 * @Description- Definition for all String Operation
 * @Author-Ayushi Shukla
 * 
 */

import java.util.*;

public class MyString {

    // 1. Append
    String appendString(Scanner sc, String str) {
        System.out.print("Enter text to append: ");
        String add = sc.nextLine();
        str += add;
        return str;
    }

    // 2. Count Words
    int countWords(String str) {
        int count=0;
        for(char c:str.toCharArray()){
            if(c==' '){
                count++;
            }
        }
        return count+1;
    }

    // 3. Replace
   String replace(String str, char oldChar, char newChar) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == oldChar) {
            result += newChar;   // replace manually
        } else {
            result += c;         // keep original
        }
    }
   return result;
}

    // 4. Palindrome
    boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
       return true;
    }

    // 5. Splice
    String spliceString(Scanner sc, String str) {
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        return str.substring(0, start) + str.substring(end);
        
    }

    // 6. Split
     String splitLetters(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) + " "; 
        }
        return result;
    }

    // 7. Max Repeating Character
    char maxRepeatingChar(String str) {
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
         return maxChar;
    }

    // 8. Sort
String sortString(String str) {
    char[] arr = str.toCharArray();
    int n = arr.length;

    // Bubble sort
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap arr[j] and arr[j+1]
                char temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    // Convert sorted char array back to string
    str = new String(arr);
    return str;
}


    // 9. Shift
    String shiftString(String str) {
        if (str.length() > 1) 
			str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
        return str;
    }

    // 10. Reverse
    String reverseString(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--)
			reverse += str.charAt(i);
       return reverse;
    }
}
