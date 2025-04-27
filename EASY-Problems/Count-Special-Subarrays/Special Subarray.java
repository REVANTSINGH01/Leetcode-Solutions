/**
 * ================================================
 * Problem: Count Special Subarrays
 * ================================================
 * 
 * You are given an array `nums`.
 * 
 * A subarray of length 3 is considered "special" if:
 * 2 * (nums[left] + nums[right]) == nums[mid]
 * where mid = left + 1 and right = left + 2.
 * 
 * Task:
 * Count the number of such special subarrays.
 * 
 * Example:
 * Input: nums = [1, 3, 5, 7, 9]
 * Output: 2
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int left = 0;
        int right = left + 2;
        int len = nums.length;

        while (right < len) {
            int sum = nums[left] + nums[right];
            
            // Check the special condition
            if (2 * sum == nums[left + 1]) {
                count++;
            }

            left++;
            right++;
        }

        return count;
    }
}
