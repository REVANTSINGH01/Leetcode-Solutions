/**
 * ==========================================================
 *   LEETCODE PROBLEM: Find Middle Index in Array (LC #1991)
 * ==========================================================
 * Given a 0-indexed integer array `nums`, find the *leftmost* 
 * middle index such that the sum of elements strictly to the 
 * left is equal to the sum of elements strictly to the right.
 *
 * If no such index exists, return -1.
 * 
 * Example:
 * Input: nums = [2,3,-1,8,4]
 * Output: 3
 *
 * Explanation:
 * - Left sum of index 3: 2 + 3 + (-1) = 4
 * - Right sum of index 3: 4
 * => Both are equal, so return index 3
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - -1000 <= nums[i] <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int findMiddleIndex(int[] nums) {
        int left = 0;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int right = totalSum - left - nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}
