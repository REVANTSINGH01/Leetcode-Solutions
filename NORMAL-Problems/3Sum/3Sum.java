/**
 * =====================================================
 *     LEETCODE PROBLEM: 3SUM (LC #15)
 * =====================================================
 * Given an integer array `nums`, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * The solution set must not contain duplicate triplets.
 *
 * =========================
 * Example 1:
 * =========================
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * =========================
 * Example 2:
 * =========================
 * Input: nums = [0,1,1]
 * Output: []
 *
 * =========================
 * Example 3:
 * =========================
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 *
 * =========================
 * Constraints:
 * =========================
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 *
 * =========================
 * Approach:
 * =========================
 * - Sort the array to make it easier to skip duplicates.
 * - Use a fixed pointer `i`, and apply a two-pointer approach (`left` and `right`)
 *   to find pairs that sum with nums[i] to zero.
 * - Skip duplicate elements to avoid repeated triplets.
 *
 * =========================
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) (excluding output list)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort array to use two-pointer technique
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // Two-pointer search for target pair
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for third number
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }

        return result;
    }
}
