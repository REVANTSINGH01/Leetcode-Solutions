/**
 *
 *                PROBLEM: BINARY SEARCH
 *
 * 
 * Given a sorted array of integers and a target value, return the index 
 * of the target if found. If not, return -1.
 * 
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * 
 * Time Complexity: O(log n) - We use binary search to find the target.
 * Space Complexity: O(1) - We do not use extra space.
 */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0; // Left pointer
        int high = nums.length - 1; // Right pointer

        while (low <= high) {
            int mid = (low + high) / 2; // Calculate middle index

            // If the middle element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }
            // If target is greater, search in the right half
            else if (target > nums[mid]) {
                low = mid + 1;
            }
            // If target is smaller, search in the left half
            else {
                high = mid - 1;
            }
        }
        return -1; // Target not
