/**
 * =============================================================================
 * LeetCode Problem: Roman to Integer
 * =============================================================================
 * 
 * Given a Roman numeral string `s`, convert it to an integer.
 * Roman numerals are usually written from largest to smallest left to right.
 * However, there are exceptions: for example, IV (4), IX (9), etc.
 * 
 * Approach:
 * - Traverse the Roman numeral string from right to left.
 * - Convert each Roman character to its integer value.
 * - If 4 * current value < accumulated result, subtract; otherwise, add.
 * 
 * Why 4 * current value? This is a trick to detect subtractive combinations
 * (like IV, IX, etc.), which are always placed before a symbol at least 5 times
 * their value, and no subtractive combination involves subtracting more than once.
 *
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(1), constant space usage.
 */

class Solution {
    public int romanToInt(String s) {
        int ans = 0, num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }

            // Apply subtraction rule if necessary
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }

        return ans;
    }
}
