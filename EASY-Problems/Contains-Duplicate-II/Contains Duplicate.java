/**
 *    LEETCODE PROBLEM: CONTAINS DUPLICATE II 
 *
 * Given an integer array `nums` and an integer `k`,
 * return true if there are two distinct indices `i` and `j` in the array
 * such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * Approach:
 * - Use a HashSet to store the elements within the window of size `k`.
 * - If the HashSet contains the current number, return true (duplicate found).
 * - If the window size exceeds `k`, remove the oldest element to maintain the window size.
 *
 * Time Complexity: O(n) - Each element is added and removed from the HashSet once.
 * Space Complexity: O(k) - HashSet stores up to `k + 1` elements.
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> list = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Check for duplicate within the window
            if (list.contains(nums[i])) return true;
            
            // Add current number to the set
            list.add(nums[i]);
            
            // Maintain window size by removing the oldest element
            if (list.size() > k) list.remove(nums[i - k]);
        }
        
        return false; // Return false if no duplicates are found within the window
    }
}
