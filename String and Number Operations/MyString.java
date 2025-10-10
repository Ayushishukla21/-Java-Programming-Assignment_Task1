/**
 * @Filename-MyString.java
 * @Description- Definition for all String Operations (without inbuilt functions)
 * @Author- Ayushi Shukla
 */

import java.util.*;

public class MyString {

    // 1. Count unique palindromes 
    int countUniquePalindromes(String str) {
        if (str == null || str.length() < 3)
            return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j < str.length(); j++) {
                if (isPalindrome(str, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    // 2. Convert snake_case to camelCase
    String snakeToCamel(String str) {
        String result = "";
        boolean upper = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                upper = true;
                continue;
            }
            if (upper && c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
                upper = false;
            }
            result = result + c;
        }
        return result;
    }

    // 3. Count consonants
    int countConsonants(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                      c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                    count++;
                }
            }
        }
        return count;
    }

    // 4. Expand compressed string like a1b3c2 -> abbbcc
    String expand(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int num = 0;
            i++;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = num * 10 + (str.charAt(i) - '0');
                i++;
            }
            i--;
            for (int j = 0; j < num; j++)
                result = result + ch;
        }
        return result;
    }

    // 5. Compress string by frequency (aabbbc -> a2b3c1)
    String compress(String str) {
        String result = "";
        for (int i = 0; i < str.length(); ) {
            char ch = str.charAt(i);
            int count = 1;
            i++;
            while (i < str.length() && str.charAt(i) == ch) {
                count++;
                i++;
            }
            result = result + ch + count;
        }
        return result;
    }

    // 6. Find length of longest substring without repeating characters
    int longestUniqueSubstring(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            boolean[] visited = new boolean[256];
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                if (visited[str.charAt(j)])
                    break;
                visited[str.charAt(j)] = true;
                len++;
            }
            if (len > max)
                max = len;
        }
        return max;
    }
}
