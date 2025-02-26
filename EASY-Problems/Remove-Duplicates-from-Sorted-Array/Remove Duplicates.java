/**
 *
 *              PROBLEM: REMOVE DUPLICATES FROM ARRAY
 *
 * 
 * Given a sorted integer array nums, remove the duplicates **in-place** 
 * such that each unique element appears only once. The function should 
 * return the new length of the array after removing duplicates.
 * 
 * Time Complexity: O(n) - We traverse the array once, performing O(1) operations per element.
 * Space Complexity: O(1) - We modify the array in place without using extra space.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0
        if (nums.length == 0) return 0;
        
        // Pointer 'i' keeps track of the position where the next unique element should be placed
        int i = 0;

        // Loop through the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If the current element is not a duplicate, move it to the correct position
            if (nums[i] != nums[j]) {
                i++;  // Move the unique index forward
                nums[i] = nums[j];  // Place the unique element at the new position
            }
        }
        // Return the new length of the modified array
        return i + 1;
    }
}
