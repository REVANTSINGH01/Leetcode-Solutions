/**
 * =============================================================================
 * LeetCode Problem: 2951 - Find the Peaks
 * =============================================================================
 *
 * Problem Statement:
 * Given an integer array `mountain`, return a list of all indices `i` such that:
 *   - `0 < i < mountain.length - 1`, and
 *   - `mountain[i - 1] < mountain[i] > mountain[i + 1]`
 * 
 * In other words, return all indices of **peaks** in the mountain array.
 * 
 * A peak is an element that is strictly greater than both of its neighbors.
 *
 * Approach:
 * - Traverse from index 1 to `mountain.length - 2`
 * - At each index `i`, check if `mountain[i]` is greater than both neighbors.
 * - If true, add index `i` to the result list.
 *
 * Time Complexity: O(n), where n is the length of the array.
 * Space Complexity: O(1) auxiliary (O(k) output list where k is number of peaks).
 */

class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }
}
