/**
 * =============================================================================
 * LeetCode Problem: 1482 - Minimum Number of Days to Make m Bouquets
 * =============================================================================
 *
 * Problem Statement:
 * You are given an integer array `bloomDay`, an integer `m`, and an integer `k`.
 * You need to make `m` bouquets. To make a bouquet, you need to use `k` adjacent 
 * flowers from the garden. The garden consists of `bloomDay.length` flowers, and 
 * the `i`th flower will bloom in `bloomDay[i]` days.
 *
 * Return the minimum number of days you need to wait to be able to make `m` bouquets
 * from the garden. If it is impossible to make m bouquets, return -1.
 *
 * Constraints:
 * - 1 <= bloomDay.length <= 10^5
 * - 1 <= bloomDay[i] <= 10^9
 * - 1 <= m <= 10^6
 * - 1 <= k <= bloomDay.length
 *
 * Approach:
 * - Perform binary search on the range of days from min(bloomDay) to max(bloomDay).
 * - For each candidate mid day, check if we can form at least m bouquets with k adjacent flowers.
 * - In the helper function `canBloom(...)`, count adjacent bloomed flowers.
 *   If count reaches k, one bouquet is formed.
 * 
 * Time Complexity: O(n * log(max_day - min_day))
 * Space Complexity: O(1) — constant extra space
 */

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long required = (long) m * k;
        
        // If not enough flowers
        if (n < required) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find min and max bloom days
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        // Binary search for minimum valid day
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canBloom(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * Helper method to check if we can form `m` bouquets by `mid` days.
     * We need `k` adjacent bloomed flowers per bouquet.
     */
    public boolean canBloom(int[] bloomDay, int mid, int m, int k) {
        int flowers = 0;
        int bouquets = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                // One bouquet formed
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // reset if not continuous
            }
        }

        return bouquets >= m;
    }
}
