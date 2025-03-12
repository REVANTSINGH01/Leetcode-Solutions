/**
 *    LEETCODE PROBLEM: NUMBER OF 1 BITS
 *
 * Write a function that takes an unsigned integer and returns
 * the number of '1' bits it has (also known as the Hamming weight).
 * 
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string has three '1' bits.
 * 
 * Example 2:
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * 
 * Approach:
 * - Convert the integer `n` to its binary representation as a string.
 * - Count the occurrences of '1' in the string.
 * 
 * Time Complexity: O(k) - where k is the number of bits in `n`.
 * Space Complexity: O(k) - due to storing the binary string.
 */

class Solution {
    public int hammingWeight(int n) {
        // Convert the number to binary string representation
        String num = Integer.toBinaryString(n);
        
        int count = 0;

        // Count the number of '1' bits
        for (char c : num.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}
