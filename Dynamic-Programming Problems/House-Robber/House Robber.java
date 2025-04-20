/**
 * ============================================
 * LEETCODE PROBLEM: House Robber (LC #198)
 * ============================================
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, and the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * systems connected — and it will automatically contact the police if two
 * adjacent houses are broken into on the same night.
 *
 * Given an integer array `nums` representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // Either rob current house + i-2, or skip current and take i-1
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len - 1];
    }
}
