/**
 * ===================================================
 *    LEETCODE PROBLEM: POWER OF FOUR 
 * ===================================================
 * Given an integer `n`, return `true` if it is a power of four.
 * Otherwise, return `false`.
 *
 * Example 1:
 * Input: n = 16
 * Output: true
 * Explanation: 4^2 = 16
 *
 * Example 2:
 * Input: n = 5
 * Output: false
 * Explanation: 5 is not a power of four.
 *
 * Constraints:
 * - -2^31 <= n <= 2^31 - 1
 *
 * Approach:
 * - If `n <= 0`, return `false`.
 * - While `n` is divisible by 4, divide it by 4.
 * - If `n` becomes 1, return `true`. Otherwise, return `false`.
 *
 * Time Complexity: O(log n) - Dividing by 4 reduces the input size logarithmically.
 * Space Complexity: O(1) - Constant space used.
 */

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        
        // Keep dividing by 4 until n is no longer divisible by 4
        while (n % 4 == 0) {
            n /= 4;
        }
        
        // If n becomes 1, it is a power of four
        return n == 1;
    }
}
