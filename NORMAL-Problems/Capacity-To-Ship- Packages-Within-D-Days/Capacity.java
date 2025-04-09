/**
 * ============================================================================
 *    LEETCODE PROBLEM: Capacity To Ship Packages Within D Days (LC #1011)
 * ============================================================================
 * 
 * Problem:
 * - Given an array `weights` representing the weights of packages
 *   and an integer `days`, determine the least weight capacity 
 *   of a ship that will result in all the packages being shipped 
 *   within `days`.
 * 
 * Approach:
 * - Use binary search to minimize the ship capacity.
 * - The minimum possible capacity is the max package weight.
 * - The maximum possible capacity is the sum of all weights.
 * - Use a helper function to check if a given capacity can 
 *   transport all packages in the given number of days.
 * 
 * Time Complexity: O(n * log(sum(weights) - max(weights)))
 * Space Complexity: O(1)
 */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Minimum capacity is the max weight
        int low = Arrays.stream(weights).max().getAsInt();
        // Maximum capacity is the sum of all weights
        int high = Arrays.stream(weights).sum();

        // Binary search for the minimal sufficient capacity
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canTransportAll(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Helper function to check if all packages can be shipped 
     * within given days using a given ship capacity.
     */
    public boolean canTransportAll(int[] weights, int capacity, int days) {
        int total_days = 1;
        int current_load = 0;

        for (int weight : weights) {
            current_load += weight;
            if (current_load > capacity) {
                total_days++;
                current_load = weight; // Start a new day
            }
        }

        return total_days <= days;
    }
}
