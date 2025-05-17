/**
 * ============================================================================
 * LeetCode Problem: 66 - Plus One
 * ============================================================================
 *
 * Problem Statement:
 * You are given a large integer represented as an integer array `digits`, 
 * where each `digits[i]` is the i-th digit of the integer.
 * The digits are stored such that the most significant digit is at the head of the array.
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Constraints:
 * - 1 <= digits.length <= 100
 * - 0 <= digits[i] <= 9
 * - The integer does not contain any leading 0s.
 *
 * Approach:
 * 1. Traverse the array from the last digit toward the first.
 * 2. If the digit is less than 9, increment it and return.
 * 3. If the digit is 9, set it to 0 and continue (carry forward the 1).
 * 4. If all digits are 9, we create a new array of length `n+1` with 1 at index 0.
 *
 * Example:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) in the worst case (all 9s)
 */

class Solution {
    public int[] plusOne(int[] digits) {
        // Step 1: Traverse digits from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            // If incrementing doesn't cause a carry
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            // Set current digit to 0 and continue
            digits[i] = 0;
        }

        // Step 2: Handle the case when all digits were 9 (e.g., [9,9] -> [1,0,0])
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
