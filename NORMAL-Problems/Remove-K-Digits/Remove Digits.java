/**
 * =============================================================================
 * LeetCode Problem: 402 - Remove K Digits
 * =============================================================================
 *
 * Problem Statement:
 * Given a non-negative integer `num` represented as a string and an integer `k`, 
 * remove `k` digits from the number so that the new number is the smallest possible.
 * Return the resulting number as a string.
 * 
 * Note: The result should not contain leading zeros. If the final result is empty, return "0".
 *
 * Constraints:
 * - 1 <= num.length <= 10^5
 * - 0 <= k <= num.length
 * - num consists of only digits.
 *
 * Approach:
 * - Use a stack to maintain a monotonically increasing sequence of digits.
 * - Traverse the number and remove digits from the stack when the current digit is smaller 
 *   than the top of the stack and we still have digits to remove (`k > 0`).
 * - After the loop, remove any remaining digits from the end if `k > 0`.
 * - Build the resulting number from the stack and remove any leading zeros.
 * - Return the final number or "0" if the result is empty.
 *
 * Time Complexity: O(n), where n is the length of the input number.
 * Space Complexity: O(n), for storing digits in the stack and result.
 */

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // Remove remaining digits from the end if needed
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the final result
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
