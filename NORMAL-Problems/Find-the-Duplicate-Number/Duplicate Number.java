/**
 *              PROBLEM: FIND THE DUPLICATE NUMBER
 * 
 * Given an array of integers `nums` containing `n + 1` integers where each 
 * integer is between `1` and `n` (inclusive), return the duplicate number.
 * 
 * Example:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * Time Complexity: O(n) - Floyd’s cycle detection algorithm runs in linear time.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // Slow pointer
        int fast = nums[0]; // Fast pointer

        // Detect cycle in the array using Floyd's Tortoise and Hare algorithm
        while (true) {
            slow = nums[slow];         // Move slow pointer by 1 step
            fast = nums[nums[fast]];   // Move fast pointer by 2 steps
            if (slow == fast) {        // Cycle detected
                break;
            }
        }

        int slow2 = nums[0]; // New pointer for finding the duplicate
        while (slow != slow2) {
            slow = nums[slow];   // Move both pointers one step at a time
            slow2 = nums[slow2];
        }

        return slow; // The duplicate number
    }
}
