/* *
* @Filename-MyNumber.java 
 * @Description- Definition for all Number Operations (without inbuilt functions) 
 * @Author- Ayushi Shukla 
 * */
public class MyNumber {

    // 1. Nth Fibonacci number (Iterative, optimized)
    int fibonacci(int position) {
        if (position < 0) return -1;
        if (position <= 1) return position;

        int first = 0, second = 1, sum = 0;
        for (int index = 2; index <= position; index++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // 2. Binary to Decimal
    int binaryToDecimal(String binaryString) {
        if (binaryString == null || binaryString.isEmpty()) {
            throw new IllegalArgumentException("Binary string cannot be null or empty.");
        }

        int decimal = 0;
        for (int index = 0; index < binaryString.length(); index++) {
            char currentChar = binaryString.charAt(index);
            if (currentChar != '0' && currentChar != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + currentChar);
            }
            decimal = decimal * 2 + (currentChar - '0');
        }
        return decimal;
    }

    // 3. Prime check
    boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            if (number % divisor == 0) return false;
        }
        return true;
    }

    // 4. Number to Words (0–999999999)
    String numberToWords(int number) {
        if (number == 0) return "zero";
        return convertToWords(number).trim();
    }

    private String convertToWords(int number) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                          "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                          "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        StringBuilder wordResult = new StringBuilder();

        if (number >= 1000000) {
            wordResult.append(convertToWords(number / 1000000)).append(" million ");
            number %= 1000000;
        }
        if (number >= 1000) {
            wordResult.append(convertToWords(number / 1000)).append(" thousand ");
            number %= 1000;
        }
        if (number >= 100) {
            wordResult.append(units[number / 100]).append(" hundred ");
            number %= 100;
        }
        if (number >= 20) {
            wordResult.append(tens[number / 10]).append(" ");
            number %= 10;
        }
        if (number > 0) {
            wordResult.append(units[number]).append(" ");
        }

        return wordResult.toString();
    }
}
