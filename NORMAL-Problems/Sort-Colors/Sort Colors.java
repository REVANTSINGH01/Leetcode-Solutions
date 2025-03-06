/**
 *              PROBLEM: SORT COLORS
 * 
 * Given an array `nums` containing `0s, 1s, and 2s`, 
 * sort the array **in-place** without using extra space.
 * 
 * Example:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Constraints:
 * - Do not use the built-in sort function.
 * - Solve it in O(n) time and O(1) space.
 * 
 * Time Complexity: O(n) - Single pass (Dutch National Flag Algorithm)
 * Space Complexity: O(1) - Sorting in-place
 */

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;         // Pointer to place 0s
        int mid = 0;         // Pointer to place 1s
        int high = nums.length - 1; // Pointer to place 2s
        
        while (mid <= high) { 
            if (nums[mid] == 0) {  
                // Swap nums[low] and nums[mid], move both forward
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {  
                // No swap needed, just move mid forward
                mid++;    
            } 
            else {  
                // Swap nums[mid] and nums[high], move high backward
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
