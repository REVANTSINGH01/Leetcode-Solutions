/**
 *
 *              PROBLEM: ROTATE STRING
 * 
 * Given two strings s and goal, return true if and only if s can become 
 * goal after some number of shifts on s.
 * 
 * A shift consists of moving the leftmost character of s to the rightmost position.
 * 
 * Example:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * 
 * Time Complexity: O(n) - Checking substring takes O(n) with KMP.
 * Space Complexity: O(n) - Due to concatenation of string s + s.
 */

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String res = s + s; // Concatenating s with itself
        return res.contains(goal); // Checking if goal is a substring
    }
}
