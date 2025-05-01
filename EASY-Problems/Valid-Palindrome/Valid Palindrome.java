/**
 * ========================================================
 * LeetCode Problem: 125. Valid Palindrome
 * ========================================================
 *
 * Given a string `s`, return true if it is a palindrome, or false otherwise.
 * A string is a palindrome if it reads the same backward as forward after
 * converting all letters to lowercase and removing all non-alphanumeric characters.
 *
 * Approach:
 * 1. Convert the string to lowercase.
 * 2. Build a cleaned version by including only alphanumeric characters.
 * 3. Check if the cleaned string is equal to its reverse.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        int len = s.length();
        String lowerCase = s.toLowerCase();

        // Filter out non-alphanumeric characters
        for (int i = 0; i < len; i++) {
            char curr = lowerCase.charAt(i);
            if ((curr >= 'a' && curr <= 'z') || (curr >= '0' && curr <= '9')) {
                str.append(curr);
            }
        }

        // Check if the cleaned string equals its reverse
        return str.toString().equals(str.reverse().toString());
    }
}
