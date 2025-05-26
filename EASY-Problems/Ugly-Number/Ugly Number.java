/**
 * ============================================================================
 * LeetCode Problem: 263 - Ugly Number
 * ============================================================================
 *
 * Problem Statement:
 * An ugly number is a positive number whose prime factors are limited to 2, 3, and 5.
 * Given an integer `n`, return true if `n` is an ugly number.
 *
 * Constraints:
 * - n can be negative or zero.
 *
 * Approach:
 * - If n is less than or equal to 0, it cannot be an ugly number.
 * - Continuously divide `n` by 2, 3, and 5 as long as it's divisible.
 * - If the final result is 1, it's an ugly number.
 *
 * Time Complexity: O(log n), because we divide the number by its prime factors.
 * Space Complexity: O(1), constant space used.
 */

class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }
}
