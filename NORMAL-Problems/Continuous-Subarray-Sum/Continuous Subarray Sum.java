/**
 * ================================================================
 * LEETCODE PROBLEM: 523. Continuous Subarray Sum
 * ================================================================
 * 
 * Given an integer array `nums` and an integer `k`, return true if 
 * `nums` has a continuous subarray of size at least two whose elements 
 * sum up to a multiple of `k`, otherwise return false.
 * 
 * A subarray is a contiguous part of the array.
 * 
 * Example:
 * Input: nums = [23, 2, 4, 6, 7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose sum = 6, which is a multiple of 6.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(k) for the hashmap storing remainders
 */

import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store remainder and its earliest index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Handles the case where subarray starts at index 0

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Modulo operation to keep track of sum % k
            if (k != 0) {
                sum %= k;

                // Handle negative remainders (if ever needed)
                if (sum < 0) {
                    sum += k;
                }
            }

            if (map.containsKey(sum)) {
                // Check if the subarray is at least of length 2
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                // Only store the first occurrence of this remainder
                map.put(sum, i);
            }
        }

        return false;
    }
}
