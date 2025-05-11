/**
 *===========================================
 * LeetCode: 1550. Three Consecutive Odds
 *===========================================
 * Problem Statement:
 * Given an array of integers arr, return true if there are three consecutive odd numbers, otherwise return false.
 *
 * Approach:
 * - Loop through the array up to length - 2
 * - Check if current and next two elements are all odd
 * - If found, return true
 * - If loop completes, return false
 *
 * Time Complexity: O(n), where n is the length of the array
 * Space Complexity: O(1)
 */

public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        // Iterate through the array, stopping at length - 2 to avoid out-of-bound errors
        for (int i = 0; i < arr.length - 2; i++) {
            // Check if three consecutive numbers are all odd
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        // If no three consecutive odd numbers are found
        return false;
    }

}
