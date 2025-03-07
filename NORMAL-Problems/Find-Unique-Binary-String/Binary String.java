/**
 *   LEETCODE 1980: FIND UNIQUE BINARY STRING
 * 
 * Given an array of binary strings `nums` where each string 
 * is of length `n`, return a binary string of length `n` 
 * that does not exist in `nums`.
 * 
 * Example 1:
 * Input: nums = ["01","10"]
 * Output: "11"
 * 
 * Example 2:
 * Input: nums = ["00","01"]
 * Output: "11"
 * 
 * Time Complexity: O(n) - Iterates once over `nums`
 * Space Complexity: O(1) - Only a single string variable is used
 */

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String ans = "";
        int n = nums.length;

        // Generate a binary string by flipping the diagonal elements
        for (int i = 0; i < n; i++) {
            ans += nums[i].charAt(i) == '0' ? '1' : '0';
        }

        return ans;
    }
}
