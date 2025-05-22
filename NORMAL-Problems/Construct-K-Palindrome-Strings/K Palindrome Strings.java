/**
 * ============================================================================
 * LeetCode Problem: 1400 - Construct K Palindrome Strings
 * ============================================================================
 *
 * Problem Statement:
 * Given a string `s` and an integer `k`, return true if `s` can be rearranged 
 * to construct `k` palindrome strings. Otherwise, return false.
 *
 * Constraints:
 * - Each palindrome must use all characters in `s` exactly once.
 * - Each character must appear in exactly one of the `k` palindromes.
 *
 * Approach:
 * 1. If the length of the string is less than `k`, it's impossible (not enough characters).
 * 2. Count the frequency of each character using a HashMap.
 * 3. Count how many characters have an odd frequency (`oddCount`).
 * 4. We can construct at most `k` palindromes if the number of odd-frequency characters 
 *    is less than or equal to `k`, because each odd-frequency character needs to be 
 *    the center of a palindrome.
 *
 * Time Complexity: O(n), where n is the length of string `s`.
 * Space Complexity: O(1), since at most 26 lowercase characters are stored in the map.
 */

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        // Step 1: Count character frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count characters with odd frequency
        int oddCount = 0;
        for (int freq : map.values()) {
            if (freq % 2 != 0) oddCount++;
        }

        // Step 3: We can construct `k` palindromes only if oddCount <= k
        return oddCount <= k;
    }
}
