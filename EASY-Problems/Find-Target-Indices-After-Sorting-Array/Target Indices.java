/**
 * ============================================================
 *    LEETCODE PROBLEM: FIND TARGET INDICES AFTER SORTING 
 * ============================================================
 * Given a 0-indexed integer array `nums` and an integer `target`, return the indices
 * where `target` would appear in the sorted array. Return the result in ascending order.
 *
 * Note: The solution doesn't sort the array. Instead, it calculates the position
 * using the number of smaller and equal elements.
 *
 * Example 1:
 * Input: nums = [1,2,5,2,3], target = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1,2,5,2,3], target = 3
 * Output: [3]
 *
 * Example 3:
 * Input: nums = [1,2,5,2,3], target = 5
 * Output: [4]
 *
 * Approach:
 * - First, count how many numbers are **less than** the target.
 * - Then, count how many numbers are **equal to** the target.
 * - Using this information, generate target indices using the formula:
 *   `less + i` for `i` in the range from `0` to `count - 1`.
 *
 * Time Complexity: O(N) - Single pass for counting and one for result generation.
 * Space Complexity: O(1) - Constant space excluding the result storage.
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // List to store the result indices
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        int less = 0;

        // Count numbers less than and equal to target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) less++; // Track numbers smaller than target
            if (nums[i] == target) count++; // Track occurrences of target
        }

        // Generate target indices using the calculated values
        for (int i = 0; i < count; i++) {
            result.add(less + i);
        }

        return result;
    }
}
