/**
 * =============================================================================
 * LeetCode Problem: 992 - Subarrays with K Different Integers
 * =============================================================================
 *
 * Problem Statement:
 * Given an integer array `nums` and an integer `k`, return the number of good 
 * subarrays of `nums`. A good array is defined as a contiguous subarray 
 * that contains exactly `k` distinct integers.
 * 
 * Approach:
 * - Use the sliding window technique to count the number of subarrays with 
 *   at most K distinct integers.
 * - The number of subarrays with exactly K distinct elements is:
 *        atMostK(k) - atMostK(k - 1)
 * - This works because `atMostK(k)` includes all subarrays with up to `k` 
 *   distinct elements, and subtracting `atMostK(k-1)` removes those with 
 *   less than `k`, leaving exactly `k`.
 *
 * Time Complexity:
 * - O(n), where n is the length of the input array `nums`.
 *
 * Space Complexity:
 * - O(N), where N is the range of possible numbers (max value in nums),
 *   here assumed to be ≤ 20000.
 */

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    /**
     * Helper method to count number of subarrays with at most k distinct integers.
     */
    public int atMostK(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int distinct = 0;
        int count = 0;
        int[] freq = new int[20001];  // Based on constraint: 1 <= nums[i] <= 20000

        while (right < n) {
            int val = nums[right];
            if (freq[val] == 0) {
                distinct++;
            }
            freq[val]++;

            // Shrink the window until at most k distinct elements remain
            while (distinct > k) {
                int leftVal = nums[left];
                freq[leftVal]--;
                if (freq[leftVal] == 0) {
                    distinct--;
                }
                left++;
            }

            // All subarrays ending at `right` with at most k distinct numbers
            count += right - left + 1;
            right++;
        }

        return count;
    }
}
