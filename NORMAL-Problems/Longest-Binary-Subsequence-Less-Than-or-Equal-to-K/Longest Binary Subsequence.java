/**
 * =============================================================================
 * LeetCode Problem: 2311 - Longest Binary Subsequence Less Than or Equal to K
 * =============================================================================
 *
 * Problem Statement:
 * Given a binary string `s` and an integer `k`, return the length of the longest 
 * subsequence of `s` that represents a binary number less than or equal to `k`.
 *
 * A subsequence is a string that can be derived from another string by deleting 
 * some or no characters without changing the order of the remaining characters.
 *
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s[i] is either '0' or '1'
 * - 0 <= k <= 10^9
 *
 * Approach:
 * - All '0's can be safely included in the subsequence since they don't contribute to increasing the binary value.
 * - Traverse the binary string from right to left (least significant bit first).
 * - Use bitwise logic to calculate the binary value of including each '1'.
 * - Only include a '1' if adding its positional value keeps the total <= k.
 * - Stop processing if the power of 2 exceeds k, as any further 1s will exceed the allowed value.
 *
 * Time Complexity: O(n), where n is the length of the string `s`
 * Space Complexity: O(1), using constant extra space
 */

class Solution {
    public int longestSubsequence(String s, int k) {
        int zero = 0;
        int one = 0;
        long power = 1;
        long value = 0;

        // Count all '0's which can always be included
        for (char ch : s.toCharArray()) {
            if (ch == '0') zero++;
        }

        // Traverse from right to left to consider including '1's
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                // Only include '1' if its positional contribution keeps value <= k
                if (value + power > k) continue;

                value += power;
                one++;
            }

            power <<= 1; // Multiply power by 2

            // If power exceeds k, any additional '1's would exceed k
            if (power > k) break;
        }

        return zero + one;
    }
}
