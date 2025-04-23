/**
 * ================================================
 * LEETCODE PROBLEM: Binary Subarrays With Sum (LC #930)
 * ================================================
 *
 * Given a binary array `nums` and an integer `goal`, return the number of 
 * non-empty subarrays with a sum equal to `goal`.
 *
 * A subarray is a contiguous part of the array.
 *
 * Example:
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 *
 * Explanation:
 * The 4 subarrays are:
 * - [1,0,1]
 * - [1,0,1,0]
 * - [0,1,0,1]
 * - [1,0,1]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;

        // Initialize prefix sum map with 0 sum having 1 frequency
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            // Check if there's a prefix sum that leads to `goal`
            if (map.containsKey(sum - goal)) {
                result += map.get(sum - goal);
            }

            // Update the current sum frequency in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
