/**
 *    LEETCODE PROBLEM: REMOVE ALL ADJACENT DUPLICATES IN STRING 
 *
 * Given a string `s`, remove all adjacent duplicates in the string.
 * The final string should not contain any consecutive duplicate characters.
 *
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 *
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 *
 * Approach:
 * - Use a stack to process the characters.
 * - If the stack is empty or the top of the stack is different from the current character, push it.
 * - If the top of the stack is the same as the current character, pop it (removing adjacent duplicates).
 * - Construct the final string by reversing the stack contents.
 *
 * Time Complexity: O(N) - We traverse the string once and perform push/pop operations.
 * Space Complexity: O(N) - Stack stores characters from the string.
 */

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        int i = 0;
        String result = "";
        Stack<Character> list = new Stack<>();
        
        while (i < s.length()) {
            if (list.isEmpty() || list.peek() != s.charAt(i)) {
                list.push(s.charAt(i));
                i++;
            } else {
                list.pop();
                i++;
            }
        }
        
        while (!list.isEmpty()) {
            result += list.pop();
        }
        
        return new StringBuilder(result).reverse().toString();
    }
}
