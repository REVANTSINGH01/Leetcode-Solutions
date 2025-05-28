/**
 * =============================================================================
 * LeetCode Problem: 209 - Minimum Size Subarray Sum
 * =============================================================================
 *
 * Problem Statement:
 * Given an array of positive integers `nums` and a positive integer `target`, 
 * return the minimal length of a contiguous subarray of which the sum is 
 * greater than or equal to `target`. If there is no such subarray, return 0 instead.
 *
 * Constraints:
 * - 1 <= target <= 10^9
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 *
 * Approach:
 * - Use the sliding window technique to maintain a window with a sum >= target.
 * - Expand the window by moving `right` pointer and shrink it by moving `left` 
 *   while the sum condition is satisfied.
 * - Keep track of the minimum window length.
 *
 * Time Complexity: O(n) — Each element is visited at most twice.
 * Space Complexity: O(1) — Constant space usage.
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                length = Math.min(length, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
