/**
 * ==========================================================
 *    LEETCODE PROBLEM: INTERSECTION OF TWO ARRAYS
 * ==========================================================
 * Given two integer arrays `nums1` and `nums2`, return an array of their intersection.
 * Each element in the result must be unique, and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4] (or [4,9])
 *
 * Approach:
 * - Use a HashSet to store unique elements of `nums1`.
 * - Traverse `nums2` and check for intersections using the HashSet.
 * - Store results in another HashSet to ensure uniqueness.
 * - Convert the HashSet to an integer array as the final result.
 *
 * Time Complexity: O(N + M) - Where N is the size of `nums1` and M is the size of `nums2`.
 * Space Complexity: O(N + M) - Due to the usage of HashSets for storage.
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Store unique elements of nums1
        HashSet<Integer> temp = new HashSet<>();
        for (int num : nums1) {
            temp.add(num);
        }

        // Find intersections using a HashSet
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (temp.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert the resultSet to an array
        int result[] = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index] = num;
            index++;
        }

        return result;
    }
}
