/**
 *                  PROBLEM: TWO SUM
 *
 * Given an array of integers `nums` and an integer `target`, 
 * return indices of the two numbers such that they add up to `target`.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * - Each input has exactly one solution, and the same element cannot be used twice.
 * - The solution must return indices in O(n) time complexity.
 * 
 * Time Complexity: O(n) - Each element is checked once using HashMap.
 * Space Complexity: O(n) - HashMap stores at most `n` elements.
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store numbers and their indices
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];  // Current number
            int diff = target - num;  // Complement needed to reach target

            // Check if complement exists in the map
            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            // Store the current number with its index
            prevMap.put(num, i);
        }

        // If no solution found (this case is guaranteed not to happen per constraints)
        return new int[] {}; 
    }
}
