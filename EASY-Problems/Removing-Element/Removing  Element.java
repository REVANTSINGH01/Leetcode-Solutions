/**
 *
 *              PROBLEM: REMOVE ELEMENT FROM ARRAY
 *
 * Given an integer array nums and an integer val, remove all occurrences 
 * of val in-place. The function should return the new length of the array 
 * after removing all occurrences of val.
 * 
 * Time Complexity: O(n) - We traverse the array once, performing O(1) operations per element.
 * Space Complexity: O(1) - We modify the array in place without using extra space.
 */

class Solution {
    public int removeElement(int[] nums, int val) {
        // Initialize an index to keep track of the position where non-val elements should be placed
        int index = 0;
        
        // Iterate through the array
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not equal to the given value
            if (nums[j] != val) {
                // Swap the current element with the element at index position
                int temp = nums[index];
                nums[index] = nums[j];
                nums[j] = temp;
                
                // Move the index forward
                index++;
            }
        }
        // Return the new length of the modified array 
        return index;
    }
}
