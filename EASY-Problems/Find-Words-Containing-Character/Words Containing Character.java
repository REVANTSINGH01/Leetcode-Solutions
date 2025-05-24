/**
 * ============================================================================
 * LeetCode Problem: 2942 - Find Words Containing Character
 * ============================================================================
 *
 * Problem Statement:
 * Given an array of strings `words` and a character `x`, return a list of all 
 * indices `i` such that `words[i]` contains the character `x`.
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 100
 * - `words[i]` consists of lowercase English letters.
 * - `x` is a lowercase English letter.
 *
 * Approach:
 * - Iterate through each word in the array.
 * - For each word, scan through its characters.
 * - If the character `x` is found, record the index and break the inner loop.
 * - Return the list of indices.
 *
 * Time Complexity: O(n * m), where n = number of words and m = average word length.
 * Space Complexity: O(k), where k = number of matching indices added to the result list.
 */

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == x) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
