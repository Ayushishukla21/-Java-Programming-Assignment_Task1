/**
 * @Filename-MyNumber.java
 * @Description- Definition for all Number Operations (without inbuilt functions)
 * @Author- Ayushi Shukla
 */

public class MyNumber {

    // 1. Nth Fibonacci number
    int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 2. Binary to Decimal conversion
    int binaryToDecimal(String bin) {
        int result = 0;
        for (int i = 0; i < bin.length(); i++) {
            char c = bin.charAt(i);
            if (c == '1')
                result = result * 2 + 1;
            else
                result = result * 2;
        }
        return result;
    }

    // 3. Prime check
    boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // 4. Number to Words (0–999999999)
    String numberToWords(int n) {
        if (n == 0) return "zero";
        return convert(n);
    }

    private String convert(int n) {
        String[] oneToNineteen = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                  "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                                  "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String result = "";

        if (n >= 1000000) {
            result += convert(n / 1000000) + " million ";
            n %= 1000000;
        }
        if (n >= 1000) {
            result += convert(n / 1000) + " thousand ";
            n %= 1000;
        }
        if (n >= 100) {
            result += oneToNineteen[n / 100] + " hundred ";
            n %= 100;
        }
        if (n >= 20) {
            result += tens[n / 10] + " ";
            n %= 10;
        }
        if (n > 0) {
            result += oneToNineteen[n];
        }
        return result.trim();
    }
}
