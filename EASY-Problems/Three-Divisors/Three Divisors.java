/**
 * ==========================================================
 *    LEETCODE PROBLEM: THREE DIVISORS 
 * ==========================================================
 * Given an integer `n`, return `true` if `n` has exactly three positive divisors. Otherwise, return `false`.
 * 
 * Example 1:
 * Input: n = 2
 * Output: false
 * 
 * Example 2:
 * Input: n = 4
 * Output: true
 * Explanation: The divisors of 4 are 1, 2, and 4.
 *
 * Approach:
 * - If a number has exactly three divisors, it must be a perfect square of a prime number.
 * - Iterate from 2 to n-1 and count divisors.
 * - If the count equals 1, return `true`, otherwise return `false`.
 *
 * Time Complexity: O(N) - Linear iteration to check divisors.
 * Space Complexity: O(1) - Constant space for variables.
 */

class Solution {
    public boolean isThree(int n) {
        int count = 0;

        // Check for divisors from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) count++;
        }

        // Return true if exactly one divisor is found (excluding 1 and n)
        return count == 1;
    }
}
