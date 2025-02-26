/**
 *
 *      PROBLEM: CHECK IF ARRAY IS SORTED AND ROTATED
 *
 * 
 * Given an array, determine if it is sorted in non-decreasing order
 * and then rotated at some pivot unknown to you beforehand.
 * 
 * Example:
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * 
 * Time Complexity: O(n) - We iterate through the array once.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public boolean check(int[] nums) {
        int count = 0;

        // Check if the last element is greater than the first element
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }

        // Count the number of times an element is greater than its next element
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        // If the count is more than 1, it's not a rotated sorted array
        return count <= 1;
    }
}
