/**
 * =============================================================================
 * LeetCode Problem: 739 - Daily Temperatures
 * =============================================================================
 *
 * Problem Statement:
 * Given an array of integers `temperatures` representing the daily temperatures,
 * return an array `answer` such that `answer[i]` is the number of days you have to wait
 * after the i-th day to get a warmer temperature. If there is no future day for which 
 * this is possible, set `answer[i] = 0`.
 *
 * Constraints:
 * - 1 <= temperatures.length <= 10^5
 * - 30 <= temperatures[i] <= 100
 *
 * Approach:
 * - Use a monotonic decreasing stack to keep track of indices with unresolved warmer days.
 * - Traverse the array, and for each temperature, resolve previous colder days.
 * - For every popped index, set the result as the difference between current and stored index.
 * - Push current index to the stack for future processing.
 *
 * Time Complexity: O(n), where n is the number of days.
 * Space Complexity: O(n), for the stack and the result array.
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
