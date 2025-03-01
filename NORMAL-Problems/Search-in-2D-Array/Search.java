/**
 *              PROBLEM: SEARCH A 2D MATRIX
 * 
 * You are given an `m x n` matrix where:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 * 
 * Given an integer `target`, return `true` if `target` is found in the matrix,
 * and `false` otherwise.
 * 
 * Example:
 * Input:
 * matrix = [
 *   [1, 3, 5, 7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 60]
 * ]
 * target = 3
 * Output: true
 * 
 * Time Complexity: O(log(m * n)) - Binary search on a flattened matrix
 * Space Complexity: O(1) - No extra space used
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;  // Handle edge case where matrix is empty
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int mvalue = matrix[mid / n][mid % n]; // Convert 1D index to 2D indices
            
            if (mvalue == target) {
                return true;
            } else if (mvalue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
