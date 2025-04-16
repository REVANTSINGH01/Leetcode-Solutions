/**
 * ===================================================
 *     LEETCODE PROBLEM: Find Pivot Index (LC #724)
 * ===================================================
 * Given an array of integers `nums`, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly
 * to the left of the index is equal to the sum of all the numbers strictly
 * to the index's right.
 * 
 * If the index is found, return it. If no such index exists, return -1.
 *
 * Example:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * 
 * Explanation:
 * - The sum of the numbers to the left of index 3: 1 + 7 + 3 = 11
 * - The sum of the numbers to the right of index 3: 5 + 6 = 11
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -1000 <= nums[i] <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int pivotIndex(int[] nums) {
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
