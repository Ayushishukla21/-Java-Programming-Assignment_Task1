/**
 * @Filename-MyString.java
 * @Description- Definition for all String Operations (without inbuilt functions)
 * @Author- Ayushi Shukla
 */

import java.util.*;

public class MyString {

    // 1. Count unique palindromes of length >= 3
    int countUniquePalindromes(String inputString) {
        if (inputString == null || inputString.length() < 3)
            return 0;

        Set<String> uniquePalindromes = new HashSet<>();
        int inputLength = inputString.length();

        for (int start = 0; start < inputLength; start++) {
            for (int end = start + 2; end < inputLength; end++) {
                if (isPalindrome(inputString, start, end)) {
                    uniquePalindromes.add(inputString.substring(start, end + 1));
                }
            }
        }
        return uniquePalindromes.size();
    }

    private boolean isPalindrome(String inputString, int left, int right) {
        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // 2. Convert snake_case to camelCase
    String snakeToCamel(String snakeCaseString) {
        StringBuilder camelCaseBuilder = new StringBuilder();
        boolean capitalizeNext = false;

        for (int index = 0; index < snakeCaseString.length(); index++) {
            char currentChar = snakeCaseString.charAt(index);

            if (currentChar == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    camelCaseBuilder.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    camelCaseBuilder.append(currentChar);
                }
            }
        }
        return camelCaseBuilder.toString();
    }

    // 3. Count consonants in the string
    int countConsonants(String inputString) {
        if (inputString == null || inputString.isEmpty()) return 0;

        int consonantCount = 0;
        for (int index = 0; index < inputString.length(); index++) {
            char character = inputString.charAt(index);
            if (Character.isLetter(character) && !isVowel(character)) {
                consonantCount++;
            }
        }
        return consonantCount;
    }

    private boolean isVowel(char character) {
        return "aeiouAEIOU".indexOf(character) >= 0;
    }

    // 4. Expand encoded string (like a1b3c2 -> abbbcc)
    String expand(String encodedString) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < encodedString.length(); index++) {
            char character = encodedString.charAt(index);
            int repeatCount = 0;

            index++;
            while (index < encodedString.length() && Character.isDigit(encodedString.charAt(index))) {
                repeatCount = repeatCount * 10 + (encodedString.charAt(index) - '0');
                index++;
            }
            index--; // Adjust index after overshoot

            result.append(String.valueOf(character).repeat(repeatCount));
        }

        return result.toString();
    }

    // 5. Compress string (e.g. aaabbc -> a3b2c1)
    String compress(String inputString) {
        if (inputString == null || inputString.isEmpty()) return "";

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < inputString.length(); ) {
            char currentChar = inputString.charAt(index);
            int count = 1;
            index++;

            while (index < inputString.length() && inputString.charAt(index) == currentChar) {
                count++;
                index++;
            }

            result.append(currentChar).append(count);
        }

        return result.toString();
    }

    // 6. Find length of longest substring without repeating characters
    int longestUniqueSubstring(String inputString) {
        int maxLength = 0;
        int start = 0;
        Set<Character> seenCharacters = new HashSet<>();

        for (int end = 0; end < inputString.length(); end++) {
            char currentChar = inputString.charAt(end);

            while (seenCharacters.contains(currentChar)) {
                seenCharacters.remove(inputString.charAt(start));
                start++;
            }

            seenCharacters.add(currentChar);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
