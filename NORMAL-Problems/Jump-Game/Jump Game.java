/**
 * ========================================================
 * LeetCode Problem: 55. Jump Game
 * ========================================================
 *
 * Description:
 * You are given an array `nums` where each element represents your maximum 
 * jump length from that position. Return true if you can reach the last index, 
 * or false otherwise.
 *
 * Approach:
 * 1. Use a greedy strategy to keep track of the furthest index (`Maxindex`) we can reach.
 * 2. Iterate through the array:
 *    - If the current index is greater than `Maxindex`, we can't reach it — return false.
 *    - Otherwise, update `Maxindex` as the max of current `Maxindex` and (i + nums[i]).
 * 3. If we complete the loop, return true — we can reach the end.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean canJump(int[] nums) {
        int Maxindex = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If current index is beyond the maximum reachable index, we can't proceed
            if (i > Maxindex) {
                return false;
            }

            // Update the maximum reachable index
            Maxindex = Math.max(Maxindex, i + nums[i]);
        }

        return true;
    }
}
