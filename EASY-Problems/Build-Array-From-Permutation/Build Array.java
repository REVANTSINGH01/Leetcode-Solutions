/**
 * ========================================================
 * LeetCode Problem: 1920. Build Array from Permutation
 * ========================================================
 *
 * Description:
 * Given a zero-based permutation array `nums`, construct an array `ans`
 * where ans[i] = nums[nums[i]] for each index i (0 <= i < nums.length).
 *
 * Return the resulting array.
 *
 * Approach:
 * 1. Create a new array `ans` of the same length as `nums`.
 * 2. Iterate through the array and set ans[i] = nums[nums[i]].
 *
 * Time Complexity: O(n) — where n is the length of nums
 * Space Complexity: O(n) — for the output array
 */

class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            // Set ans[i] to nums[nums[i]] as per the problem definition
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
