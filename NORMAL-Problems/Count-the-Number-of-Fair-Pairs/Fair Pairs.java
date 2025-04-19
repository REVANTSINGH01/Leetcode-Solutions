/**
 * ==========================================================
 * LEETCODE PROBLEM: Count the Number of Fair Pairs (LC #2563)
 * ==========================================================
 *
 * Given an integer array `nums` and two integers `lower` and `upper`, 
 * return the number of fair pairs.
 *
 * A pair (i, j) is fair if:
 * - 0 <= i < j < nums.length
 * - lower <= nums[i] + nums[j] <= upper
 *
 * The algorithm uses sorting + binary search to efficiently count 
 * valid pairs within the given range.
 *
 * Example:
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * Output: 6
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long lower_sum = 0;
        long higher_sum = 0;

        // Count pairs with sum > (lower - 1)
        for (int i = 0; i < n - 1; i++) {
            int low = i + 1, high = n - 1, pos = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[i] + nums[mid] > lower - 1) {
                    pos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            lower_sum += (n - pos);
        }

        // Count pairs with sum > upper
        for (int i = 0; i < n - 1; i++) {
            int low = i + 1, high = n - 1, pos = n;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[i] + nums[mid] > upper) {
                    pos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            higher_sum += (n - pos);
        }

        return lower_sum - higher_sum;
    }
}
