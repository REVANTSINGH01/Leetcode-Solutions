/**
 * ========================================================
 * LeetCode Problem: Count Subarrays Where Max Element Appears at Least K Times
 * ========================================================
 *
 * You are given an integer array `nums` and an integer `k`.
 * A subarray is valid if the maximum element in the entire array 
 * appears at least `k` times in the subarray.
 *
 * Return the number of valid subarrays.
 *
 * Approach:
 * 1. Find the maximum value in the array.
 * 2. Convert each element to 1 if it equals the maximum, else 0.
 * 3. Use sliding window to count subarrays with at least k max elements.
 * 4. For each such window, add the count of subarrays ending at or after `right`.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int n = nums.length;

        // Step 1: Find max value
        int max = Arrays.stream(nums).max().getAsInt();

        // Step 2: Mark 1 if element == max, else 0
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == max) ? 1 : 0;
        }

        // Step 3: Sliding window approach
        int left = 0, right = 0;
        long sum = 0;

        while (right < n) {
            sum += nums[right];

            // Step 4: When sum of max elements reaches k
            while (sum >= k) {
                count += n - right;
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return count;
    }
}
