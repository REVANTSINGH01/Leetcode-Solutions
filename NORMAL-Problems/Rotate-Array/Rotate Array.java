/**
 *              PROBLEM: ROTATE ARRAY
 * 
 * Given an integer array `nums`, rotate the array to the right by `k` steps, 
 * where `k` is non-negative.
 * 
 * Example:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * 
 * Time Complexity: O(n) - We reverse the array three times, each taking O(n).
 * Space Complexity: O(1) - The rotation is performed in-place.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length; // Handle cases where k > nums.length
        reverse(nums, 0, nums.length - 1); // Reverse the entire array
        reverse(nums, 0, k - 1); // Reverse the first k elements
        reverse(nums, k, nums.length - 1); // Reverse the remaining elements
    }

    // Helper function to reverse elements in the array between two indices
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
