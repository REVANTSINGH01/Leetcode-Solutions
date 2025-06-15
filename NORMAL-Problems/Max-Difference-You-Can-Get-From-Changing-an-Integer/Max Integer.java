/**
 * =============================================================================
 * LeetCode Problem: Maximum Difference by Changing a Digit
 * =============================================================================
 *
 * Problem Statement:
 * - Given an integer num, you can replace any digit with another digit (0-9).
 * - You want to maximize and minimize the value by replacing digits.
 * - Return the difference between the maximum and minimum numbers you can form.
 *
 * Approach:
 * - For maximum value:
 *      - Find first digit (from left) which is not 9.
 *      - Replace all occurrences of that digit with '9'.
 * - For minimum value:
 *      - If the first digit is not '1', replace all its occurrences with '1'.
 *      - Else, find first digit (from left after first position) which is not '1' or '0'.
 *      - Replace all occurrences of that digit with '0'.
 *
 * Time Complexity: O(n), where n is the number of digits.
 * Space Complexity: O(1), only constant extra space used (except string conversions).
 */

class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;

        // Find first digit not equal to '9' for max calculation
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }

        // Calculate min value
        if (t.charAt(0) != '1') {
            t = t.replace(t.charAt(0), '1');
        } else {
            int pos1 = 0;
            while (pos1 < t.length() && (t.charAt(pos1) == '1' || t.charAt(pos1) == '0')) {
                pos1++;
            }
            if (pos1 < t.length()) {
                t = t.replace(t.charAt(pos1), '0');
            }
        }

        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}
