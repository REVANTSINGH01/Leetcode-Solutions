/**
 *              PROBLEM: Find the Index of the First Occurrence in a String
 * 
 * Given two strings `haystack` and `needle`, return the index of the 
 * first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.
 * 
 * Example:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Time Complexity: O(n) - The `contains()` and `indexOf()` methods run in linear time.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) { // Check if needle exists in haystack
            return haystack.indexOf(needle); // Return the index of first occurrence
        }
        return -1; // If needle is not found
    }
}
