/**
 *              PROBLEM: POWER OF TWO
 * Given an integer `n`, determine if it is a power of two.
 * A number is a power of two if there exists an integer `x` 
 * such that 2^x == n.
 * 
 * Example 1:
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * Example 2:
 * Input: n = 3
 * Output: false
 * 
 * Example 3:
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 * 
 * Constraints:
 * -2³¹ <= n <= 2³¹ - 1
 * 
 * Time Complexity: O(1) - Constant time bitwise operations.
 * Space Complexity: O(1) - No extra space used.
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Edge case: Negative numbers and zero cannot be powers of two
        if (n <= 0) return false; 
        
        // Iterate through the first 31 powers of 2 (since 2^31 exceeds int range)
        for (int i = 0; i < 31; i++) { 
            if ((1 << i) == n) { // Check if shifting 1 left by i positions equals n
                return true;
            }
        }
        return false;  
    }
}
