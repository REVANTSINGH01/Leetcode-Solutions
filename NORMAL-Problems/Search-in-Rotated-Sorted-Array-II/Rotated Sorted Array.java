/**
 *        PROBLEM: SEARCH IN ROTATED SORTED ARRAY II
 * 
 * Given an integer array `nums` sorted in non-decreasing order (possibly rotated)
 * and an integer `target`, return `true` if `target` is in `nums`, otherwise return `false`.
 * This must be solved in O(log n) time complexity.
 * 
 * Example:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Explanation:
 * - We use a modified binary search to account for the rotated portion.
 * - If duplicates exist at both ends (`nums[low] == nums[mid] == nums[high]`), we reduce the search space.
 * - Otherwise, we follow standard binary search logic.
 * 
 * Time Complexity: O(log n) - In most cases, but O(n) in the worst case (when all elements are duplicates).
 * Space Complexity: O(1) - No extra space used.
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Found the target
            if (nums[mid] == target) {
                return true;
            }

            // Handling duplicates: shrink search space
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }
        return false;
    }
}
