/**
 *              LEETCODE PROBLEM: MOVE ZEROES
 * 
 * Given an integer array `nums`, move all 0's to the end 
 * while maintaining the relative order of non-zero elements.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 * 
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - In-place modification.
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; // Pointer to track position for non-zero elements

        // Traverse through the array
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) { 
                // Swap non-zero element with the element at index 'i'
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; // Move pointer forward
            }
        }
    }
}
