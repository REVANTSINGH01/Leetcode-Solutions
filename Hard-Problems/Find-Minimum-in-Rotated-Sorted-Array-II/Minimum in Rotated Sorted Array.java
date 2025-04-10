/**
 * ====================================================================
 *   LEETCODE PROBLEM: Find Minimum in Rotated Sorted Array (LC #153)
 * ====================================================================
 * Given a rotated sorted array without duplicates, find the minimum element.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - -5000 <= nums[i] <= 5000
 * - All the integers of nums are unique.
 * - nums is sorted and rotated at some pivot.
 *
 * Approach:
 * - If array length is 1, return that single element.
 * - Use two-pointer-style scanning from both ends toward the center.
 * - At each step, update the minimum value found.
 *
 * Time Complexity: O(n) — Linear scan of half the array.
 * Space Complexity: O(1) — Constant space.
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int output = Integer.MAX_VALUE;
        
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                output = Math.min(output, nums[i]);
                output = Math.min(output, nums[n - i - 1]);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                output = Math.min(output, nums[i]);
                output = Math.min(output, nums[n - i - 1]);
            }
            output = Math.min(output, nums[n / 2]);
        }
        
        return output;
    }
}
