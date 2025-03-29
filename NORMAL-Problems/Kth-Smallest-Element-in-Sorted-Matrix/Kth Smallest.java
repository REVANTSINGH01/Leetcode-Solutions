/**
 * ===============================================================
 *    LEETCODE PROBLEM: Kth Smallest Element in a Sorted Matrix
 * ===============================================================
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order,
 * return the kth smallest element in the matrix.
 *
 * Example 1:
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 *
 * Example 2:
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 *
 * Approach:
 * - Perform a binary search on the value range between the smallest and largest elements in the matrix.
 * - For each mid value, count how many elements are less than or equal to mid using a matrix traversal.
 * - Adjust the search range using the count to find the kth smallest element.
 *
 * Time Complexity: O(n * log(max-min)) - Matrix traversal for each binary search step.
 * Space Complexity: O(1) - Constant space used for variables.
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; // Minimum value in the matrix
        int high = matrix[n - 1][n - 1]; // Maximum value in the matrix

        // Perform binary search on the value range
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int row = n - 1;
            int col = 0;

            // Count elements <= mid using a two-pointer approach
            while (row >= 0 && col < n) {
                if (matrix[row][col] <= mid) {
                    count += (row + 1); // Add all elements in the current column
                    col++;
                } else {
                    row--;
                }
            }

            // Adjust the binary search range
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
