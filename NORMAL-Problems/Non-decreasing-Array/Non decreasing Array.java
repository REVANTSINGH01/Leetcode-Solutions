/**
 * =======================================================
 *   LEETCODE PROBLEM: Non-decreasing Array (LC #665)
 * =======================================================
 * 
 * Given an array `nums` with n integers, your task is to check 
 * if it could become non-decreasing by modifying at most one element.
 * 
 * A non-decreasing array is an array where nums[i] <= nums[i + 1] 
 * for every i (0 <= i <= n - 2).
 * 
 * -------------------------------------------------------
 * Example 1:
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get [1,2,3].
 * 
 * Example 2:
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't make the array non-decreasing with only one change.
 * 
 * -------------------------------------------------------
 * Approach:
 * - Traverse the array and count how many times nums[i] > nums[i+1].
 * - If this count exceeds 1, return false.
 * - If it's the first violation or if nums[i-1] <= nums[i+1], modify nums[i].
 * - Else, modify nums[i+1].
 * 
 * -------------------------------------------------------
 * Time Complexity: O(n) 
 * Space Complexity: O(1)
 */

class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0; // To count modifications

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false;

                // Modify nums[i] if at the start or it's safe
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    // Else modify nums[i + 1]
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
