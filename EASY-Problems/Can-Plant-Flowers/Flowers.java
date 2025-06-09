/**
 * =============================================================================
 * LeetCode Problem: 605 - Can Place Flowers
 * =============================================================================
 *
 * Problem Statement:
 * You have a long flowerbed in which some plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array `flowerbed` containing 0s and 1s, where 0 means empty
 * and 1 means not empty, and an integer `n`, return true if `n` new flowers
 * can be planted in the `flowerbed` without violating the no-adjacent-flowers rule.
 *
 * Constraints:
 * - 1 <= flowerbed.length <= 2 * 10^4
 * - flowerbed[i] is 0 or 1.
 * - There are no two adjacent flowers in flowerbed.
 * - 0 <= n <= flowerbed.length
 *
 * Approach:
 * - Traverse through the flowerbed array.
 * - For each plot, if it is empty (0), check whether the previous and next plots
 *   are also empty or out of bounds.
 * - If so, plant a flower (set current index to 1) and increment the count.
 * - Return true if count >= n, else false.
 *
 * Time Complexity: O(n), where n is the length of the flowerbed.
 * Space Complexity: O(1), in-place checking and planting.
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if current plot is empty
            if (flowerbed[i] == 0) {
                // Check left and right plots
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                // If both adjacent plots are empty or non-existent, plant a flower
                if (left && right) {
                    flowerbed[i] = 1; // Plant a flower
                    count++;          // Increment planted count

                    // If required number of flowers are planted, return true
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }

        // Check if total planted flowers meet or exceed the requirement
        return count >= n;
    }
}
