/**
 *      LEETCODE PROBLEM: NUMBER OF SUBSTRINGS CONTAINING ALL THREE CHARACTERS 
 *
 * Given a string `s` consisting only of characters `a`, `b`, and `c`, 
 * return the number of substrings containing at least one occurrence of all these characters.
 * 
 * Example 1:
 * Input: s = "abcabc"
 * Output: 10
 * 
 * Example 2:
 * Input: s = "aaacb"
 * Output: 3
 * 
 * Example 3:
 * Input: s = "abc"
 * Output: 1
 * 
 * Approach:
 * - Use a sliding window with two pointers `left` and `right`.
 * - Maintain a frequency array `freq[]` of size 3 to track occurrences of 'a', 'b', and 'c'.
 * - Expand the window by moving `right` until all three characters are present.
 * - Once all are present, count valid substrings using `len - right`.
 * - Shrink the window from the left by incrementing `left` and adjusting the frequency array.
 * - Continue until all possible substrings are evaluated.
 * 
 * Time Complexity: O(N) - Each character is processed at most twice (once by `right` and once by `left`).
 * Space Complexity: O(1) - Constant space used for the frequency array of size 3.
 */

class Solution {
    public int numberOfSubstrings(String s) {
        int result = 0;
        int len = s.length();
        int freq[] = new int[3];
        int left = 0;
        int right = 0;

        // Sliding window to count substrings containing all characters
        while (right < len) {
            char curr = s.charAt(right);
            freq[curr - 'a']++;

            // Check if all characters are present
            while (allTrue(freq)) {
                result += len - right; // Count valid substrings
                char remove = s.charAt(left);
                freq[remove - 'a']--;
                left++; // Shrink the window
            }
            right++; // Expand the window
        }
        return result;
    }

    // Helper function to check if all characters 'a', 'b', and 'c' are present
    public boolean allTrue(int freq[]) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}
