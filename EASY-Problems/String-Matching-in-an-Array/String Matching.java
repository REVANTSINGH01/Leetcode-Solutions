/**
 * ==========================================================
 *    LEETCODE PROBLEM: String Matching in an Array
 * ==========================================================
 * 
 * Given an array of strings `words`, return all strings in `words`
 * that are substrings of another word in the list.
 *
 * Example:
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 30
 * - words[i] contains only lowercase English letters.
 *
 * ----------------------------------------------------------
 * APPROACH:
 * - Use two nested loops to compare every string with the others.
 * - If one word contains another as a substring, add it to the result.
 * - Check both directions for each pair to ensure complete coverage.
 *
 * Time Complexity: O(N^2 * L), where N is the number of words
 * and L is the average string length (due to contains check).
 * Space Complexity: O(N) for the output list.
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];

                if (s1.contains(s2) && !list.contains(s2)) {
                    list.add(s2);
                }

                if (s2.contains(s1) && !list.contains(s1)) {
                    list.add(s1);
                }
            }
        }

        return list;
    }
}
