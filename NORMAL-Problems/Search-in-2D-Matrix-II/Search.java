/**
 *      PROBLEM: SEARCH IN A 2D MATRIX II
 * 
 * Given an `m x n` matrix where each row is sorted in ascending order
 * and each column is also sorted in ascending order, write a function
 * that searches for a given target value efficiently.
 * 
 * Example:
 * Input: matrix = 
 * [[1, 4, 7, 11, 15], 
 *  [2, 5, 8, 12, 19], 
 *  [3, 6, 9, 16, 22], 
 *  [10, 13, 14, 17, 24], 
 *  [18, 21, 23, 26, 30]]
 * 
 * target = 5
 * Output: true
 * 
 * Time Complexity: O(m + n) - We start from the top-right and traverse at most `m + n` steps.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;  // Handle edge case where matrix is empty
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1; // Start from the top-right corner

        while (row < rows && col >= 0) {
            int value = matrix[row][col];

            if (value == target) {
                return true;  // Found the target
            } else if (value < target) {
                row++;  // Move downward to a larger value
            } else {
                col--;  // Move left to a smaller value
            }
        }

        return false;  // Target not found
    }
}
