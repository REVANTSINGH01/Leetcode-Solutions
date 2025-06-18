/**
 * =============================================================================
 * LeetCode Problem: 1342 - Number of Steps to Reduce a Number to Zero
 * =============================================================================
 *
 * Problem Statement:
 * Given an integer `num`, return the number of steps to reduce it to zero.
 * In one step:
 *   - If the current number is even, divide it by 2.
 *   - If the current number is odd, subtract 1 from it.
 *
 * Constraints:
 * - 0 <= num <= 10^6
 *
 * Approach:
 * - Use a recursive helper function to count the number of steps.
 * - Base case: when `num` becomes 0, return the accumulated `count`.
 * - Recursive case:
 *   - If `num` is even, call helper(num / 2, count + 1)
 *   - If `num` is odd, call helper(num - 1, count + 1)
 *
 * Time Complexity: O(log n), because the number is halved roughly each time.
 * Space Complexity: O(log n), due to recursion stack depth.
 */

class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    public int helper(int num, int count) {
        if (num == 0) {
            return count;
        }
        return num % 2 == 0
            ? helper(num / 2, count + 1)
            : helper(num - 1, count + 1);
    }
}
