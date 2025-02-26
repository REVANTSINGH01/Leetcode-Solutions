/**
 * 
 *              PROBLEM: RUNNING SUM OF ARRAY
 * 
 * 
 * Given an integer array nums, return an array where each element 
 * at index i is the sum of all previous elements including itself.
 * 
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * 
 * Time Complexity: O(n) - We traverse the array once, updating each element in-place.
 * Space Complexity: O(1) - We modify the input array without using extra space.
 */

class Solution {
    public int[] runningSum(int[] nums) {
        // Start from index 1 and update each element as the sum of itself and the previous element
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];  // Update current index with the sum of previous elements
        }
        return nums; // Return the modified array
    }
}
