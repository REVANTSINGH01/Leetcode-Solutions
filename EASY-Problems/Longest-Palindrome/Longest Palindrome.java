/**
 * ============================================================================
 * LeetCode Problem: 409 - Longest Palindrome
 * ============================================================================
 *
 * Problem Statement:
 * Given a string `s` which consists of lowercase and/or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Constraints:
 * - Characters are case-sensitive ('A' is different from 'a').
 * - You can reorder the characters as needed.
 *
 * Approach:
 * - Use a HashSet to keep track of characters with odd occurrences.
 * - For each character:
 *   - If it's already in the set, remove it and add 2 to the result (forms a pair).
 *   - Otherwise, add it to the set.
 * - After the loop, if the set isn't empty, add 1 to account for a center character.
 *
 * Time Complexity: O(n), where n is the length of the string.
 * Space Complexity: O(1), since there are at most 52 possible letters (a-z, A-Z).
 */

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                result += 2;
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) {
            result += 1; // Add one character in the center (if available)
        }

        return result;
    }
}
