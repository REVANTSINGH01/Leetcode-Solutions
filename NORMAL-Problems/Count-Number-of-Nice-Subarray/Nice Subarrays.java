/**
 * ============================================
 * LEETCODE PROBLEM: 1248. Count Number of Nice Subarrays
 * ============================================
 *
 * Given an array of integers `nums` and an integer `k`, return the number of 
 * nice subarrays that contain exactly `k` odd numbers.
 *
 * A nice subarray is a contiguous part of the array.
 *
 * Example:
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 *
 * Explanation: The subarrays [1,1,2,1] and [1,2,1,1] have exactly 3 odd numbers.
 *
 * Approach:
 * - Convert each element to 1 if odd, 0 if even.
 * - Use prefix sum + hashmap to count the number of subarrays with sum exactly k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Step 1: Convert elements to 1 (if odd) and 0 (if even)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }

        // Step 2: Prefix sum and map to store frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle case when prefix sum itself is k

        int prefixSum = 0;
        int count = 0;

        // Step 3: Traverse through nums
        for (int num : nums) {
            prefixSum += num;

            // Check if there is a subarray ending here with exactly k odd numbers
            count += map.getOrDefault(prefixSum - k, 0);

            // Update the map with the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
