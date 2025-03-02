/**
 *              PROBLEM: MAJORITY ELEMENT
 * 
 * Given an array `nums` of size `n`, return the majority element.
 * The majority element is the element that appears more than `n / 2` times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * - `n == nums.length`
 * - `1 <= n <= 5 * 10⁴`
 * - `-10⁹ <= nums[i] <= 10⁹`
 * 
 * Time Complexity: O(n) - Boyer-Moore Voting Algorithm.
 * Space Complexity: O(1) - Constant extra space used.
 */

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num; // Set new candidate
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
