/**
 *       LEETCODE PROBLEM: MAXIMUM SUM OF PAIRS WITH EQUAL DIGIT SUM
 *
 * You are given an integer array `nums`. You can choose two different 
 * indices i and j such that the sum of the digits of `nums[i]` is equal to 
 * the sum of the digits of `nums[j]`.

 * Return the maximum value of `nums[i] + nums[j]` that can be obtained.
 * If no such pair exists, return `-1`.

 * Example 1:
 * Input: nums = [18, 43, 36, 13, 7]
 * Output: 54
 * Explanation: The pairs (18, 36) form the largest sum.

 * Example 2:
 * Input: nums = [10, 12, 19, 14]
 * Output: -1
 * Explanation: No pairs with equal digit sum exist.

 * Approach:
 * - Use a HashMap to store the maximum number for each digit sum as the key.
 * - For each number, calculate its digit sum using the `digitSum()` method.
 * - If the digit sum already exists in the map, calculate the sum of the current number and the stored number.
 * - Keep track of the maximum sum using a variable `res`.
 * - Update the map with the maximum number for the digit sum.
 * 
 * Time Complexity: O(N * K) - N for iterating through the array and K (log10(num)) for digit sum calculation.
 * Space Complexity: O(N) - For storing digit sums and numbers in the hashmap.
 */

class Solution {
    public int maximumSum(int[] nums) {
        // HashMap to store the maximum number for each digit sum
        HashMap<Integer, Integer> temp = new HashMap<>();
        int res = -1;

        for (int num : nums) {
            int key = digitSum(num);

            // Check if a number with the same digit sum exists
            if (temp.containsKey(key)) {
                res = Math.max(res, temp.get(key) + num);
                temp.put(key, Math.max(temp.get(key), num));
            } else {
                temp.put(key, num);
            }
        }
        return res;
    }

    // Helper function to calculate the digit sum of a number
    public int digitSum(int nums) {
        int sum = 0;
        while (nums > 0) {
            sum += nums % 10;
            nums /= 10;
        }
        return sum;
    }
}
