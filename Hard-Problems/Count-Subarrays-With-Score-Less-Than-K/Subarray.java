/**
 * ================================================
 * LeetCode Problem: Count Subarrays Where Score < k (LC #2762)
 * ================================================
 *
 * You are given an integer array `nums` and a long integer `k`.
 *
 * A subarray's "score" is defined as (sum of subarray elements) * (length of subarray).
 * 
 * Return the number of subarrays where the score is strictly less than `k`.
 * 
 * Example:
 * Input: nums = [2,1,4,3,5], k = 10
 * Output: 6
 *
 * Approach:
 * - Use a sliding window to maintain a valid subarray.
 * - Expand the window by moving `right`.
 * - Shrink the window from `left` whenever the score constraint is violated.
 * - Count the number of valid subarrays ending at each `right`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int left = 0;
        long sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink window from the left until the score is valid
            while (sum * (right - left + 1) >= k && left <= right) {
                sum -= nums[left];
                left++;
            }

            // Add number of valid subarrays ending at 'right'
            count += right - left + 1;
        }

        return count;
    }
}
