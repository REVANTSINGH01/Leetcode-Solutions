/**
 *    LEETCODE PROBLEM: ALTERNATING GROUPS I
 *
 * Given an integer array `colors` representing colors of stones in a circle,
 * return the number of stones that belong to an alternating group.
 * 
 * A stone at index `i` is in an alternating group if:
 * - `colors[i]` is not equal to its adjacent stones:
 *   - Left neighbor: `colors[(i + n - 1) % n]`
 *   - Right neighbor: `colors[(i + 1) % n]`
 * 
 * Example 1:
 * Input: colors = [1,2,1,2,1]
 * Output: 0
 * Explanation: No stone is alternating.
 * 
 * Example 2:
 * Input: colors = [1,2,3,4,5]
 * Output: 5
 * Explanation: All stones are alternating.
 *
 * Approach:
 * - Iterate through each stone and check its left and right neighbors using 
 *   modular arithmetic to simulate circular behavior.
 * - Increment `count` if the stone is alternating.
 *
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant space used.
 */

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;

        // Traverse each stone and check its left and right neighbors
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i + 1) % n] && colors[i] != colors[(i + n - 1) % n]) {
                count++;
            }
        }
        return count;
    }
}
