/**
 * =============================================================
 *    LEETCODE PROBLEM: Count Good Triplets
 * =============================================================
 *
 * Given an array of integers `arr` and three integers `a`, `b`, and `c`, 
 * return the number of good triplets.
 *
 * A triplet (arr[i], arr[j], arr[k]) is good if:
 * - 0 <= i < j < k < arr.length
 * - |arr[i] - arr[j]| <= a
 * - |arr[j] - arr[k]| <= b
 * - |arr[i] - arr[k]| <= c
 *
 * Example:
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 *
 * Constraints:
 * - 3 <= arr.length <= 100
 * - 0 <= arr[i] <= 1000
 * - 0 <= a, b, c <= 1000
 *
 * -------------------------------------------------------------
 * APPROACH:
 * - Use three nested loops to iterate over all valid triplets (i < j < k).
 * - Check each condition for a good triplet using `Math.abs`.
 * - Increment the count for every triplet that satisfies all conditions.
 *
 * Time Complexity: O(n^3) — due to three nested loops.
 * Space Complexity: O(1) — constant space used.
 */

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
