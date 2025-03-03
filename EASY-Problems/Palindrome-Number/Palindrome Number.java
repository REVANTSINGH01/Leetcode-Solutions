/**
 *            PROBLEM: PALINDROME NUMBER
 * 
 * Given an integer `x`, return `true` if `x` is a palindrome, 
 * otherwise return `false`. A palindrome is a number that reads 
 * the same forward and backward.
 * 
 * Example 1:
 * Input: x = 121
 * Output: true
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: -121 reversed is 121-, not the same.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * 
 * Time Complexity: O(logn) - Number of digits in `x`
 * Space Complexity: O(1) - No extra space used
 */

class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int temp = x;
        int rev = 0;

        while (temp > 0) {
            int dig = temp % 10;
            rev = (rev * 10) + dig;
            temp = temp / 10;
        }

        return rev == x; // Check if reversed number matches original
    }
}
