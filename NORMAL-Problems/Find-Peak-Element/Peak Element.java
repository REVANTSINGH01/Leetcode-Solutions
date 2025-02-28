/**
 *               PROBLEM: FIND PEAK ELEMENT
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array `nums`, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index of any peak.
 * 
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * 
 * Constraints:
 * - `nums[i] ≠ nums[i+1]` for all valid indices `i`
 * 
 * Time Complexity: O(n) - We iterate through the array once in the worst case.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        
        // If there's only one element, return its index
        if (n == 1) {
            return 0;
        }

        // Traverse the array to find a peak element
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        // Edge cases: Check the first and last elements
        if (nums[0] > nums[1]) {
            return 0;
        } else {
            return n - 1;
        }
    }
}
