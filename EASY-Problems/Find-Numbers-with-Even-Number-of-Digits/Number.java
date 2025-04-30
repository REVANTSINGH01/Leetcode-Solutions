/**
 * ========================================================
 * LeetCode Problem: 1295. Find Numbers with Even Number of Digits
 * ========================================================
 *
 * Given an array `nums` of integers, return how many of them contain an even number of digits.
 *
 * Approach:
 * 1. Iterate through the array and count digits for each number.
 * 2. Check if the number of digits is even.
 * 3. Increment the result count if it is.
 *
 * Time Complexity: O(n * log10(m)) where n = length of nums, m = max value in nums
 * Space Complexity: O(1)
 */

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        // Traverse each number in the array
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }

        return count;
    }

    // Helper method to check if a number has an even number of digits
    private boolean hasEvenDigits(int num) {
        int digitCount = 0;

        while (num > 0) {
            num /= 10;
            digitCount++;
        }

        return digitCount % 2 == 0;
    }
}
