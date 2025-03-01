/**
 *                PROBLEM: SQRT(x)
 * 
 * Given a non-negative integer `x`, compute and return the square root
 * of `x`. Since the return type is an integer, only the integer part
 * should be returned (truncate the decimal part).
 * 
 * Example:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.828..., we return only the integer part.
 * 
 * Time Complexity: O(log x) - Binary search reduces the range exponentially.
 * Space Complexity: O(1) - Constant space usage.
 */

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // Edge case: sqrt(0) = 0, sqrt(1) = 1
        }

        int left = 0, right = x, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;

            // To prevent overflow, cast to long
            long square = (long) mid * mid;

            if (square == x) {
                return mid; // Found exact square root
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right; // Return the integer part of sqrt(x)
    }
}
