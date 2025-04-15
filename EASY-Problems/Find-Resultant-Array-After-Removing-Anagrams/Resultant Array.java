/**
 * ===================================================
 *    LEETCODE PROBLEM: Remove Anagrams (LC #2273)
 * ===================================================
 * You are given a 0-indexed string array `words`, where `words[i]`
 * consists of lowercase English letters.
 * 
 * In one operation, select any index `i` such that `0 < i < words.length` 
 * and `words[i - 1]` and `words[i]` are anagrams of each other, and delete 
 * `words[i]` from `words`. Keep performing this operation until you cannot.
 * 
 * Return the result of performing all operations on `words`. 
 * The answer should be in the same order as words appeared in the input.
 *
 * Example:
 * Input: words = ["abba","baba","bbaa","cd","cd"]
 * Output: ["abba","cd"]
 * 
 * Explanation:
 * - "baba" and "bbaa" are anagrams of "abba", so we remove them.
 * - The two "cd" are anagrams of each other, so we remove one.
 *
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 10
 * - `words[i]` consists of lowercase English letters.
 *
 * Approach:
 * - Convert each word to a sorted character array to get its canonical form.
 * - Skip the word if it's an anagram of the previous one.
 * - Otherwise, add it to the result list.
 *
 * Time Complexity: O(n * m log m), where n is the number of words and m is the average word length.
 * Space Complexity: O(n * m), for storing the result list and intermediate strings.
 */

class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            
            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }
        
        return result;
    }
}
