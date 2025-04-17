/**
 * ================================================
 * LEETCODE PROBLEM: Count Equal and Divisible Pairs (LC #2176)
 * ================================================
 * 
 * Given a 0-indexed integer array `nums` and an integer `k`, 
 * return the number of pairs `(i, j)` such that:
 * 
 * - 0 <= i < j < nums.length
 * - nums[i] == nums[j]
 * - (i * j) is divisible by k
 * 
 * Example:
 * Input: nums = [3,1,2,2,2,1,3], k = 2
 * Output: 4
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;

        // Iterate through all possible pairs (i, j)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Check if elements are equal and i * j is divisible by k
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
