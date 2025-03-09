/**
 *
 *    LEETCODE PROBLEM: FIND MISSING AND REPEATED VALUES
 *
 * You are given an `n x n` grid of numbers from `1` to `n^2`, 
 * where one number is missing and one is repeated. 
 * Find and return the repeated and missing numbers.
 * 
 * Example:
 * Input: grid = [[1,3],[2,2]]
 * Output: [2,4]
 * Explanation: Number `2` appears twice, and `4` is missing.
 * 
 * Constraints:
 * - `n == grid.length == grid[i].length`
 * - `1 <= n <= 50`
 * - `1 <= grid[i][j] <= n^2`
 * 
 * Time Complexity: O(n²) - Iterating through the grid twice.
 * Space Complexity: O(n²) - Using an auxiliary array to store counts.
 */

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int length = grid.length;
        int hash[] = new int[length * length]; // Hash array to track occurrences

        // Populate the hash array with counts of each number
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                hash[grid[i][j] - 1]++;
            }
        }

        int missing = 0;
        int repeated = 0;

        // Identify the missing and repeated numbers
        for (int num = 0; num < hash.length; num++) {
            if (hash[num] > 1) repeated = num + 1; // Repeated number found
            if (hash[num] == 0) missing = num + 1; // Missing number found
        }
        
        return new int[]{repeated, missing}; // Return result
    }
}
