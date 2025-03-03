/**
 *              PROBLEM: ADD DIGITS
 * Given an integer `num`, repeatedly add all its digits 
 * until the result has only one digit.
 * 
 * Example 1:
 * Input: num = 38
 * Output: 2
 * Explanation: 3 + 8 = 11, 1 + 1 = 2
 * 
 * Example 2:
 * Input: num = 0
 * Output: 0
 * 
 * Time Complexity: O(log n) - Digits reduce by factor of 10
 * Space Complexity: O(1) - No extra space used
 */

class Solution {
    public int addDigits(int num) {
        int sum = digitSum(num);
        while (sum >= 10) {
            sum = digitSum(sum);
        }
        return sum;
    }

    // Helper function to calculate sum of digits
    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
