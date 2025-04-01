/**
 * ===================================================
 *    LEETCODE PROBLEM: COUNTING BITS
 * ===================================================
 * Given an integer `n`, return an array `ans` where:
 * `ans[i]` is the number of `1`s in the binary representation of `i`.
 *
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * - 0 -> 0 (0 ones)
 * - 1 -> 1 (1 one)
 * - 2 -> 10 (1 one)
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * - 0 -> 0 (0 ones)
 * - 1 -> 1 (1 one)
 * - 2 -> 10 (1 one)
 * - 3 -> 11 (2 ones)
 * - 4 -> 100 (1 one)
 * - 5 -> 101 (2 ones)
 *
 * Constraints:
 * - 0 <= n <= 10^5
 *
 * Approach:
 * - Iterate from `0` to `n`, using `Integer.bitCount(i)` to count 1s.
 *
 * Time Complexity: O(n) - Iterates `n` times with constant time bit count.
 * Space Complexity: O(n) - Stores the result array.
 */

class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.bitCount(i); // Count number of 1s in binary form of i
        }
        return arr;
    }
}
