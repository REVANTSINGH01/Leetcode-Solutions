/**
 * ============================================================================
 * LeetCode Problem: 45 - Jump Game II
 * ============================================================================
 *
 * Problem Statement:
 * You are given a 0-indexed array of integers `nums` where `nums[i]` represents 
 * the maximum jump length from that position. Your goal is to reach the last 
 * index in the minimum number of jumps.
 *
 * Return the minimum number of jumps to reach the last index.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - 0 <= nums[i] <= 1000
 * - It's guaranteed you can reach the last index.
 *
 * Approach:
 * - Use a greedy approach to track the farthest point we can reach (`Max`).
 * - `length` keeps track of the end of the current jump's reach.
 * - Each time we reach the end of the current jump (`i == length`), we increment `count`
 *   and update `length` to the farthest point reachable (`Max`).
 * - We iterate only up to the second last index, as we don't need to jump from the last index.
 *
 * Time Complexity: O(n), where n is the length of the array.
 * Space Complexity: O(1), constant extra space.
 */

class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        int maxReach = 0;
        int jumps = 0;
        int currentEnd = 0;

        for (int i = 0; i < len - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            // When we reach the end of the current jump's coverage
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }

        return jumps;
    }
}
