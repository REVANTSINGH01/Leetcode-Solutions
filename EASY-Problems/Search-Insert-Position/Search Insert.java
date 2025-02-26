/**
 *
 *          PROBLEM: SEARCH INSERT POSITION
 *
 * 
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.
 * 
 * Example:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * Time Complexity: O(log n) - We use binary search to find the position.
 * Space Complexity: O(1) - We do not use any extra space.
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0; // Left pointer
        int h = nums.length - 1; // Right pointer
        int a = nums.length; // Default insert position is at the end
        
        while (l <= h) {
            int mid = (l + h) / 2; // Calculate mid index
            
            // If target is found or should be inserted at mid
            if (nums[mid] >= target) {
                a = mid; // Update position
                h = mid - 1; // Move left to find the first occurrence
            } else {
                l = mid + 1; // Move right if target is greater
            }
        }
        return a; // Return insert position
    }
}
