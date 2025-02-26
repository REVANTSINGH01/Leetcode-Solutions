/**
 *
 *              PROBLEM: MISSING NUMBER
 *
 * 
 * Given an array containing `n` distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * 
 * Example:
 * Input: nums = [3,0,1]
 * Output: 2
 * 
 * Time Complexity: O(n) - We iterate through the array twice.
 * Space Complexity: O(n) - Extra space is used for the hash array.
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int hash[] = new int[n + 1]; // Create a hash array of size n+1

        // Mark the numbers present in the hash array
        for (int i = 0; i < n; i++) {
            hash[nums[i]] = 1;
        }

        int num = 0; // Variable to store the missing number

        // Find the missing number (where hash[j] is still 0)
        for (int j = 0; j < n + 1; j++) {
            if (hash[j] == 0) {
                num = j;
            }
        }

        return num;
    }
}
