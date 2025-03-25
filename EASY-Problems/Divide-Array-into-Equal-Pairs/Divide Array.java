/**
 *    LEETCODE PROBLEM: DIVIDE ARRAY INTO EQUAL PAIRS 
 *
 * Given an integer array `nums` of even length, return `true` if it is possible 
 * to reorder `nums` such that every pair of adjacent integers is equal.
 *
 * Example 1:
 * Input: nums = [3,2,3,2,2,2]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - nums.length is even.
 * - 1 <= nums[i] <= 1000
 *
 * Approach:
 * - Use the XOR operation to determine if all elements can form pairs.
 * - XOR of identical elements results in `0`, so if the final result is `0`,
 *   all numbers can be grouped into pairs.
 *
 * Time Complexity: O(N) - Single pass through the array.
 * Space Complexity: O(1) - Constant space for variables.
 */

class Solution {
    public boolean divideArray(int[] nums) {
        int result = 0;

        // Perform XOR on all elements
        for (int num : nums) {
            result ^= num;
        }

        // Check if all pairs are valid
        return result == 0;
    }
}
