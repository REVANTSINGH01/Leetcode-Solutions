/**
 *    LEETCODE PROBLEM: MAXIMUM COUNT OF POSITIVE & NEGATIVE INTEGER
 *
 * Given an array `nums` sorted in non-decreasing order, return the maximum count of 
 * either positive or negative numbers in the array.
 *
 * Example 1:
 * Input: nums = [-2,-1,-1,1,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [-3,-2,-1,0,0,1,2]
 * Output: 3
 *
 * Example 3:
 * Input: nums = [5,20,66,1314]
 * Output: 4
 *
 * Approach:
 * - Initialize `pos` and `neg` counters.
 * - Iterate through the array and update the counters for positive and negative numbers.
 * - Return the maximum of the two counts.
 *
 * Time Complexity: O(N) - We traverse the array once.
 * Space Complexity: O(1) - No extra space used.
 */

class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) pos++;
            if (num < 0) neg++;
        }
        return Math.max(pos, neg);
    }
}
