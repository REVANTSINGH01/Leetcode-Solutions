/**
 * ============================================================
 *    LEETCODE PROBLEM: REVERSE INTEGER (LC #7)
 * ============================================================
 * Given a signed 32-bit integer `x`, return `x` with its digits reversed.
 * If reversing `x` causes the value to go outside the signed 32-bit integer
 * range [-2^31, 2^31 - 1], return 0.
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Constraints:
 * - -2^31 <= x <= 2^31 - 1
 *
 * Approach:
 * - Extract digits one by one using modulus (`%`) and divide (`/`).
 * - Check for overflow before pushing the digit into the reversed number.
 * - Return 0 if the reversed number exceeds 32-bit integer limits.
 *
 * Time Complexity: O(log(x)) - The number of digits in x determines the iterations.
 * Space Complexity: O(1) - Constant space used for variables.
 */

class Solution {
    public int reverse(int x) {
        int INT_MAX = 2147483647, INT_MIN = -2147483648;
        int reversed_x = 0;

        // Loop until all digits are reversed
        while (x != 0) {
            int pop = x % 10;  // Extract last digit
            x /= 10;           // Remove last digit

            // Check for integer overflow/underflow
            if (reversed_x > INT_MAX / 10 || (reversed_x == INT_MAX / 10 && pop > 7)) return 0;
            if (reversed_x < INT_MIN / 10 || (reversed_x == INT_MIN / 10 && pop < -8)) return 0;
            
            reversed_x = reversed_x * 10 + pop; // Append digit
        }
        return reversed_x;
    }
}
