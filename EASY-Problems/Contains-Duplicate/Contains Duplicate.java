/**
 *              PROBLEM: CONTAINS DUPLICATE
 * 
 * Given an integer array `nums`, return `true` if any value 
 * appears at least twice in the array, otherwise return `false`.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * 
 * Time Complexity: O(n) - We iterate through the array once.
 * Space Complexity: O(n) - We use extra space for the HashSet.
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        // Iterate through the array and add elements to the set
        for (int num : nums) {
            if (!seen.add(num)) { // add() returns false if num already exists in the set
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }
}
