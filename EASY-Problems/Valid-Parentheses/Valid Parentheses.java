/**
 * ============================================================================
 * LeetCode Problem: 20 - Valid Parentheses
 * ============================================================================
 *
 * Problem Statement:
 * Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * A string is valid if:
 * - Open brackets are closed by the same type of brackets.
 * - Open brackets are closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only: '()[]{}'
 *
 * Approach:
 * 1. Use a stack to keep track of expected closing brackets.
 * 2. Push the corresponding closing bracket for each opening bracket.
 * 3. For closing brackets, check if it matches the top of the stack.
 * 4. If mismatch or stack is empty prematurely, return false.
 * 5. After traversal, return true only if stack is empty.
 *
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(n), for the stack used to store expected brackets.
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push the expected closing brackets for each opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            }
            // If it’s a closing bracket, check if it matches the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Valid if no unmatched brackets remain
        return stack.isEmpty();
    }
}
