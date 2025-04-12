/**
 * =============================================================
 *   LEETCODE PROBLEM:  Longest Equal Subarray
 * =============================================================
 * You are given a list of integers `nums` and an integer `k`.
 * Your task is to return the length of the longest subarray 
 * where you can remove at most `k` elements so that all remaining 
 * elements are equal.
 *
 * Approach:
 * - Use a hash array (Array of ArrayLists) to store indices of each unique number.
 * - For each list of indices, apply a sliding window to count how many elements
 *   need to be removed to make all values in that window contiguous.
 * - Track the maximum length of such a subarray.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int maxNum = Collections.max(nums); // Determine max value for sizing the array
        List<Integer>[] hashArray = new ArrayList[maxNum + 1];

        // Initialize lists
        for (int i = 0; i <= maxNum; i++) {
            hashArray[i] = new ArrayList<>();
        }

        // Populate index lists
        for (int i = 0; i < nums.size(); i++) {
            hashArray[nums.get(i)].add(i);
        }

        int maxLen = 0;

        // For each number's indices, apply sliding window
        for (List<Integer> indices : hashArray) {
            int left = 0;
            for (int right = 0; right < indices.size(); right++) {
                // If removed elements exceed k, shrink the window
                while (indices.get(right) - indices.get(left) - (right - left) > k) {
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
