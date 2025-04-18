/**
 * ================================================
 * LEETCODE PROBLEM: Power of Three (LC #326)
 * ================================================
 * 
 * Given an integer `n`, return `true` if it is a power of three.
 * Otherwise, return `false`.
 * 
 * An integer `n` is a power of three if there exists an integer `x` such that:
 * n == 3^x
 * 
 * Example:
 * Input: n = 27
 * Output: true
 * 
 * Input: n = 0
 * Output: false
 * 
 * Input: n = 9
 * Output: true
 * 
 * Time Complexity: O(log₃n)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
