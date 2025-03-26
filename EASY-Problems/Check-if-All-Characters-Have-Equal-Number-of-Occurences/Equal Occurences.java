/**
 * ===========================================================================
 *    LEETCODE PROBLEM: CHECK IF ALL CHARACTERS HAVE EQUAL FREQUENCIES
 * ===========================================================================
 * Given a string `s`, return `true` if all characters in the string have the same frequency.
 * Otherwise, return `false`.
 *
 * Example 1:
 * Input: s = "abacbc"
 * Output: true
 *
 * Example 2:
 * Input: s = "aaabb"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - `s` consists of lowercase English letters only.
 *
 * Approach:
 * - Create an integer array `hasharr` of size 26 to store character frequencies.
 * - Traverse the string and populate the frequency array using `s.charAt(i) - 'a'`.
 * - Store the frequency of the first character as `temp`.
 * - Compare all non-zero frequencies with `temp`. If any mismatch is found, return false.
 * - Otherwise, return true.
 *
 * Time Complexity: O(N + 26) → O(N) - N for traversing the string, 26 for checking frequencies.
 * Space Complexity: O(26) → O(1) - Constant space for frequency array.
 */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int hasharr[] = new int[26];
        int len = s.length();

        // Step 1: Count frequencies of characters
        for (int i = 0; i < len; i++) {
            hasharr[s.charAt(i) - 'a']++;
        }

        // Step 2: Store the frequency of the first character
        int temp = hasharr[s.charAt(0) - 'a'];

        // Step 3: Check if all non-zero frequencies match the first character's frequency
        for (int i = 0; i < hasharr.length; i++) {
            if (hasharr[i] != 0 && hasharr[i] != temp) {
                return false;
            }
        }
        return true;
    }
}
