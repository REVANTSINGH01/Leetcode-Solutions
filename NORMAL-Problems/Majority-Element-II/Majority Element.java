/**
 *             PROBLEM: MAJORITY ELEMENT II
 * 
 * Given an integer array `nums`, return all elements that appear more than `n/3` times.
 * You must solve this problem in O(n) time and O(1) space.
 * 
 * Example:
 * Input: nums = [3,2,3]
 * Output: [3]
 * 
 * Explanation:
 * - The Boyer-Moore Voting Algorithm is used to find up to two potential majority elements.
 * - We then verify their actual occurrences.
 * 
 * Time Complexity: O(n) - We iterate through the array twice.
 * Space Complexity: O(1) - We use only a few extra variables.
 */

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0; // Counters for the potential majority elements
        int candidate1 = 0, candidate2 = 0; // Potential majority element candidates

        // First pass to find potential majority elements.
        for (int i = 0; i < nums.length; i++) {
            // If count1 is 0 and the current number is not equal to candidate2, update candidate1.
            if (count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i];
            } 
            // If count2 is 0 and the current number is not equal to candidate1, update candi
