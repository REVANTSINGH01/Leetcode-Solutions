/**
 *    LEETCODE PROBLEM: REVERSE PREFIX OF WORD
 *
 * Given a string `word` and a character `ch`, reverse the prefix of `word` 
 * up to and including the first occurrence of `ch`. If `ch` does not exist 
 * in `word`, return `word` unchanged.
 *
 * Example 1:
 * Input: word = "abcdefd", ch = 'd'
 * Output: "dcbaefd"
 *
 * Example 2:
 * Input: word = "xyxzxe", ch = 'z'
 * Output: "zxyxxe"
 *
 * Example 3:
 * Input: word = "abcd", ch = 'z'
 * Output: "abcd"
 *
 * Approach:
 * - Check if `word` contains `ch`, return `word` if not.
 * - Use a stack to push characters until `ch` is found.
 * - Pop elements from the stack to construct the reversed prefix.
 * - Append the remaining part of `word` after the reversed prefix.
 *
 * Time Complexity: O(N) - We traverse `word` twice at most.
 * Space Complexity: O(N) - Stack stores prefix characters.
 */

import java.util.Stack;

class Solution {
    public String reversePrefix(String word, char ch) {
        String temp1 = String.valueOf(ch);
        if (!word.contains(temp1)) return word;

        String ans = "";
        Stack<Character> list = new Stack<>();
        int i = 0;

        while (i < word.length()) {
            list.push(word.charAt(i));
            i++;
            if (list.peek() == ch) break;
        }

        int size = list.size();
        while (!list.isEmpty()) {
            ans += list.pop();
        }

        String temp = word.substring(size);
        ans += temp;
        return ans;
    }
}
