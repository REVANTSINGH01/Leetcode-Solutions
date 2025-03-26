/**
 * ===========================================================================
 *    LEETCODE PROBLEM: FIND ALL DUPLICATES IN AN ARRAY 
 * ===========================================================================
 * Given an integer array `nums` of length `n` where all the integers are in the range [1, n] 
 * and each integer appears once or twice, return an array of all the integers that appear twice.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: []
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - 1 <= nums[i] <= n
 * - Each element appears once or twice.
 *
 * Approach:
 * - Find the maximum value using `Arrays.stream(nums).max()`.
 * - Create a hash array `hash[]` to store the frequency of each number.
 * - Traverse the input array to update the frequency count.
 * - Iterate through the hash array to find numbers with frequency greater than 1.
 * - Return the result as a list.
 *
 * Time Complexity: O(N + M) → O(N) 
 *   - N for traversing the input array and M for scanning the hash array.
 * Space Complexity: O(M) → O(N) 
 *   - M is the maximum element in the array.
 */

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Step 1: Find the maximum value in the array
        int Max = Arrays.stream(nums).max().getAsInt();

        // Step 2: Create a hash array to store frequencies
        int hash[] = new int[Max + 1];

        // Step 3: Count occurrences of each number
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        // Step 4: Find duplicates (numbers with frequency > 1)
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < hash.length; j++) {
            if (hash[j] > 1) list.add(j);
        }

        return list;
    }
}
