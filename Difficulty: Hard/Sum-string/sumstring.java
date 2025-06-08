class Solution {
    public boolean isSumString(String s) {
        // code here
        int n = s.length();

        // Try all combinations of first two parts
        for (int len1 = 1; len1 < n; len1++) {
            for (int len2 = 1; len1 + len2 < n; len2++) {
                if (checkSequence(s, 0, len1, len2)) {
                    return true;
                }
            }
        }

        return false;
    }
    
     boolean checkSequence(String s, int start, 
                                  int len1, int len2) {
        String part1 = s.substring(start, start + len1);
        String part2 = s.substring(start + len1, start + len1 + len2);

        // Leading zero check
        if ((part1.length() > 1 && part1.charAt(0) == '0') ||
            (part2.length() > 1 && part2.charAt(0) == '0')) {
            return false;
        }

        String expectedSum = addStrings(part1, part2);

        int sumLen = expectedSum.length();

        // If sum length exceeds remaining string, 
        // return false
        if (start + len1 + len2 + sumLen > s.length()) {
            return false;
        }

        String part3 = s.substring(start + len1 + len2, start + len1 + len2 + sumLen);

        // Leading zero check for sum part
        if (part3.length() > 1 && part3.charAt(0) == '0') {
            return false;
        }

        // If the sum matches the next part in string
        if (expectedSum.equals(part3)) {
            
            // If end is reached, return true
            if (start + len1 + len2 + sumLen == s.length()) {
                return true;
            }

            // Recur for next pair: part2 and expectedSum
            return checkSequence(s, start + len1, len2, sumLen);
        }

        // Sum does not match the next segment
        return false;
    }
    
    String addStrings(String num1, String num2) {
        
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int len1 = num1.length();
        int len2 = num2.length();
        String sum = "";
        int carry = 0;

        // Add from least significant digits
        for (int i = 0; i < len2; i++) {
            int d1 = num1.charAt(len1 - 1 - i) - '0';
            int d2 = num2.charAt(len2 - 1 - i) - '0';
            int digit = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            sum = (char)(digit + '0') + sum;
        }

        // Add remaining digits of num1
        for (int i = len2; i < len1; i++) {
            int d = num1.charAt(len1 - 1 - i) - '0';
            int digit = (d + carry) % 10;
            carry = (d + carry) / 10;
            sum = (char)(digit + '0') + sum;
        }

        // Add remaining carry
        if (carry > 0) {
            sum = (char)(carry + '0') + sum;
        }

        return sum;
    }
}