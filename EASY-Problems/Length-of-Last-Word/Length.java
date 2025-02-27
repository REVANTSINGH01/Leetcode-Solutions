/**
 *              PROBLEM: LENGTH OF LAST WORD
 * 
 * Given a string `s` consisting of words and spaces, return the length 
 * of the last word in the string.
 * 
 * A word is defined as a maximal substring consisting of non-space characters only.
 * 
 * Example:
 * Input: s = "Hello World"
 * Output: 5
 * 
 * Time Complexity: O(n) - We traverse the string once and split it.
 * Space Complexity: O(n) - Extra space is used for storing the split words.
 */

class Solution {
    public int lengthOfLastWord(String s) {
        String str[] = s.split(" "); // Split string by spaces
        int n = str.length - 1;      // Get index of last word
        String a = str[n];           // Store the last word
        int b = a.length();          // Get the length of last word
        return b;
    }
}
