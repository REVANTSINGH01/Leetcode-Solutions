/**
 * ============================================================================
 * LeetCode Problem: 2119 - A Number After a Double Reversal
 * ============================================================================
 *
 * Problem Statement:
 * Given an integer `num`, return true if reversing the digits of `num` twice 
 * results in the original number. Otherwise, return false.
 *
 * Insight:
 * - Reversing a number twice gives back the original only if the number 
 *   does not end with a trailing zero (except when the number is 0).
 *
 * Approach:
 * - If the number is 0, return true (edge case).
 * - If the number ends with a 0, return false (it will lose the trailing 0).
 * - Else, return true.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;                     // Special case: 0 remains the same
        return num % 10 != 0;                          // Numbers ending in 0 change on reversal
    }
}
