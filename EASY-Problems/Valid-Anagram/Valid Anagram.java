/**
 *              PROBLEM: VALID ANAGRAM
 * 
 * Given two strings `s` and `t`, return true if `t` is an anagram of `s`, 
 * and false otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters 
 * of a different word or phrase.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Time Complexity: O(n log n) - Sorting both arrays takes O(n log n).
 * Space Complexity: O(n) - Extra space is used for character arrays.
 */

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // If lengths are different, they cannot be anagrams
            return false;
        }
        char[] charArray1 = s.toCharArray(); // Convert string to character array
        char[] charArray2 = t.toCharArray();
        
        Arrays.sort(charArray1); // Sort both arrays
        Arrays.sort(charArray2);
        
        return Arrays.equals(charArray1, charArray2); // Check if both sorted arrays are equal
    }
}
