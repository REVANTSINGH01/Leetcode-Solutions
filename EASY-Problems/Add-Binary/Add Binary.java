/**
 *    LEETCODE PROBLEM: ADD BINARY
 *
 * Given two binary strings `a` and `b`, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Approach:
 * - Use two character arrays to iterate from the last index to the first.
 * - Maintain a `carry` while adding corresponding bits.
 * - Append the result to a StringBuilder and reverse it at the end.
 *
 * Time Complexity: O(max(N, M)) - We iterate through the longer binary string.
 * Space Complexity: O(max(N, M)) - StringBuilder stores the sum.
 */

class Solution {
    public String addBinary(String a, String b) {
        // Convert binary strings to character arrays
        char[] charArrA = a.toCharArray();
        char[] charArrB = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = charArrA.length - 1, j = charArrB.length - 1;
        int carry = 0;

        // Iterate from the last index of both strings
        while (i >= 0 || j >= 0 || carry > 0) {
            // Get numeric values of current characters, or 0 if out of bounds
            int aNum = i >= 0 ? charArrA[i] - '0' : 0;
            int bNum = j >= 0 ? charArrB[j] - '0' : 0;

            // Compute sum and carry
            int sum = aNum + bNum + carry;
            int digit = sum % 2;  // Current binary digit
            carry = sum / 2;      // Carry to next iteration

            // Append computed digit
            sb.append((char) (digit + '0'));

            // Move to the previous index
            i--;
            j--;
        }

        // Reverse the string and return the final result
        return sb.reverse().toString();
    }
}
