/**
 * =============================================================================
 * Custom Problem: Max Adjacent Distance
 * =============================================================================
 *
 * Problem Statement:
 * Given an array of integers `nums`, find the maximum absolute difference 
 * between any two adjacent elements, considering also the circular adjacency 
 * between the last and the first element.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * Approach:
 * - Initialize the difference as the absolute difference between the first 
 *   and last elements (to handle circular adjacency).
 * - Iterate through the array from index 1 to end.
 * - For each pair of adjacent elements, calculate the absolute difference.
 * - Keep track of the maximum difference encountered.
 *
 * Time Complexity: O(n), where n is the length of the array.
 * Space Complexity: O(1), no extra space used.
 */

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;
        int difference = Math.abs(nums[0] - nums[len - 1]);

        for (int i = 1; i < len; i++) {
            difference = Math.max(difference, Math.abs(nums[i] - nums[i - 1]));
        }
        return difference;
    }
}
