/**
 * ===================================================
 *    LEETCODE PROBLEM: MAXIMUM SUBARRAY 
 * ===================================================
 * Given an integer array `nums`, find the contiguous subarray
 * (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 *
 * Approach:
 * - Use **Kadane’s Algorithm** to find the maximum sum subarray.
 * - Maintain `temp` as the current subarray sum.
 * - If `temp` exceeds `max`, update `max`.
 * - If `temp` becomes negative, reset it to `0` (start a new subarray).
 *
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant extra space used.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE; // Stores the maximum subarray sum
        int temp = 0; // Stores the current subarray sum

        for (int i = 0; i < nums.length; i++) {
            temp += nums[i]; // Add current element to subarray sum

            if (temp >= max) {
                max = temp; // Update max if current sum is greater
            }

            if (temp < 0) {
                temp = 0; // Reset subarray sum if it goes negative
            }
        }
        return max;
    }
}
