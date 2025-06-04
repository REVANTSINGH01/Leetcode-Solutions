/**
 * =============================================================================
 * LeetCode Problem: 344 - Reverse String
 * =============================================================================
 *
 * Problem Statement:
 * Write a function that reverses a character array in-place.
 * The input is given as an array of characters `s`.
 * 
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s[i] is a printable ASCII character.
 *
 * Approach:
 * - Use two pointers: one at the beginning (`start`) and one at the end (`end`) of the array.
 * - Swap the characters at these two pointers and move them toward each other until they meet.
 * 
 * Time Complexity: O(n), where n is the length of the array.
 * Space Complexity: O(1), in-place reversal.
 */

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            // Swap characters at start and end
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            // Move pointers inward
            start++;
            end--;
        }
    }
}
