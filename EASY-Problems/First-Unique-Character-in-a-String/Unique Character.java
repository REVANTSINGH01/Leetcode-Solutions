/**
 *       LEETCODE PROBLEM: FIRST UNIQUE CHARACTER IN A STRING 
 *
 * Given a string `s`, find the first non-repeating character in it 
 * and return its index. If it does not exist, return `-1`.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * Approach:
 * - Use an integer array `freq` of size 26 to store the frequency of each character.
 * - First, iterate through the string to count the occurrences of each character.
 * - Then, iterate again to find the first character with a frequency of `1`.
 * - Return its index if found; otherwise, return `-1`.
 * 
 * Time Complexity: O(N) - Two passes over the string.
 * Space Complexity: O(1) - Fixed array of size 26.
 */

class Solution {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        if (s.length() == 0) return -1;
        
        // Count the occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
