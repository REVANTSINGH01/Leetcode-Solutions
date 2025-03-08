/**
 *         LEETCODE PROBLEM: SINGLE NUMBER (136)
 *
 * Given a non-empty array of integers `nums`, every element 
 * appears twice except for one. Find that single one.
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -3 * 10^4 <= nums[i] <= 3 * 10^4
 * - Each element appears twice except for one.
 * 
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - No extra space used.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int count = 0; // Initialize count to store the unique number

        // XOR all elements in the array
        for (int num : nums) {
            count ^= num; // XOR operation cancels out duplicate numbers
        }

        return count; // Return the single number
    }
}
