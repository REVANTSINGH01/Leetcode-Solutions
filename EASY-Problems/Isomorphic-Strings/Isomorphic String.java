/**
 *       LEETCODE PROBLEM: ISOMORPHIC STRINGS 
 *
 * Given two strings `s` and `t`, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in `s` can be replaced to get `t`.
 * All occurrences of a character must be replaced with another character while 
 * preserving the order of characters. No two characters may map to the same character, 
 * but a character may map to itself.
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Approach:
 * - Use two HashMaps to store the index of each character from `s` and `t`.
 * - Compare the indices of corresponding characters to check for a one-to-one mapping.
 * - If the index mapping is inconsistent, return `false`.
 * 
 * Time Complexity: O(N) - Single pass through the strings of length `N`
 * Space Complexity: O(N) - For storing indices in the HashMaps
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
            HashMap<Character,Integer> map1=new HashMap<>();
            HashMap<Character,Integer> map2=new HashMap<>();
            for(int i=0;i<n;i++){
                if(!map1.containsKey(s.charAt(i)))
                {
                    map1.put(s.charAt(i),i);
                }
                if(!map2.containsKey(t.charAt(i))){
                    map2.put(t.charAt(i),i);
                }
                if(!map1.get(s.charAt(i)).equals(map2.get(t.charAt(i)))){
                    return false;
                }
            }
            return true;
    }
}
