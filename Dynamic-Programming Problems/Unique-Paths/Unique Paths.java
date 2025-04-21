/**
 * ================================================
 * LEETCODE PROBLEM: Unique Paths (LC #62)
 * ================================================
 *
 * A robot is located at the top-left corner of an m x n grid.
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid.
 *
 * How many possible unique paths are there?
 *
 * Example:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the first column with 1s
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill the first row with 1s
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the grid using the recurrence:
        // dp[i][j] = paths from top + paths from left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Bottom-right cell contains the total number of unique paths
        return dp[m - 1][n - 1];
    }
}
