/**
 * ===================================================
 *    LEETCODE PROBLEM: CLIMBING STAIRS
 * ===================================================
 * You are climbing a staircase. It takes `n` steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: 1. 1 step + 1 step
 *              2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Approach:
 * - Use Dynamic Programming (DP) to solve the problem.
 * - Define an array `dp` where `dp[i]` represents the number of distinct ways to reach the i-th step.
 * - Base cases:
 *   - `dp[0] = 1` (1 way to stay at the ground)
 *   - `dp[1] = 1` (1 way to reach the first step)
 * - Use the relation: `dp[i] = dp[i-1] + dp[i-2]`
 *
 * Time Complexity: O(N) - Single pass to calculate all `dp` values.
 * Space Complexity: O(N) - For the `dp` array.
 */

class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
