/**
 *========================================================
 * Problem: Max Consecutive Ones III (Leetcode #1004)
 *========================================================
 * 
 * Description:
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 * 
 * Example:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1] (flipped two zeros)
 */

public class LongestOnesWithKFlips {
  
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (right = 0; right < nums.length; right++) {
            // Count the zeros in the window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window if we have more than k zeros
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
