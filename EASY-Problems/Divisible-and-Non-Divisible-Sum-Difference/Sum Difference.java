/**
 * =============================================================================
 * LeetCode Problem: 2894 - Difference of Sums
 * =============================================================================
 *
 * Problem Statement:
 * Given two integers `n` and `m`, define two sets:
 * - Set1 contains all integers from 1 to `n`.
 * - Set2 contains all integers from Set1 that are divisible by `m`.
 *
 * Let:
 * - `nums1` be the sum of all elements in Set1.
 * - `nums2` be the sum of all elements in Set2.
 *
 * Return the result of `nums1 - 2 * nums2`.
 *
 * Constraints:
 * - 1 <= m <= n <= 1000
 *
 * Approach:
 * 1. Use the formula for the sum of the first `n` natural numbers: n * (n + 1) / 2.
 * 2. For numbers divisible by `m`:
 *    - Count how many such numbers exist from 1 to `n` → floor(n / m).
 *    - Use arithmetic progression formula to sum these multiples of `m`.
 * 3. Return the result of `nums1 - 2 * nums2`.
 *
 * Time Complexity: O(1) — uses direct formulas, no iteration.
 * Space Complexity: O(1) — constant space usage.
 */

class Solution {
    public int differenceOfSums(int n, int m) {
        int nums1 = n * (n + 1) / 2; // Sum of numbers from 1 to n
        int temp = n / m; // Count of numbers divisible by m
        int nums2 = m * (temp * (temp + 1) / 2); // Sum of numbers divisible by m
        return nums1 - 2 * nums2;
    }
}
