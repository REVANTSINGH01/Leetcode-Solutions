/**
 *    LEETCODE PROBLEM: MAJORITY ELEMENT II
 *
 * Given an integer array `nums`, return all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: nums = [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * Approach:
 * - We use the **Boyer-Moore Voting Algorithm** to find at most two candidates.
 * - First pass determines the two most frequent candidates.
 * - Second pass verifies their actual frequency.
 *
 * Time Complexity: O(N) - We traverse the array twice.
 * Space Complexity: O(1) - Only a few integer variables are used.
 */

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        // First pass: Identify potential majority elements
        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify actual counts
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // Add valid majority elements to result
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        return result;
    }
}
