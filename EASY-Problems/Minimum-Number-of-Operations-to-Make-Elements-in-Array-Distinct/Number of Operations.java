/**
 * ================================================
 *    LEETCODE PROBLEM: Minimum Operations (LC #???)
 * ================================================
 * Given an array `nums`, return the minimum number of operations needed 
 * to remove duplicates, where one operation is defined as processing 
 * a group of 3 elements (e.g., a batch or round).
 *
 * This implementation uses a boolean array to track seen numbers and 
 * returns the number of operations (i / 3 + 1) as soon as a duplicate is found.
 *
 * Example:
 * Input: nums = [1, 2, 3, 1]
 * Output: 2
 * Explanation: Duplicate '1' found at index 3 => 3 / 3 + 1 = 2 operations
 *
 * Time Complexity: O(n) - Scans through the array once
 * Space Complexity: O(1) - Fixed-size boolean array (128 elements)
 */

class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128]; // Assuming nums[i] is in range [0, 127]
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        
        return 0; // No duplicates found
    }
}
