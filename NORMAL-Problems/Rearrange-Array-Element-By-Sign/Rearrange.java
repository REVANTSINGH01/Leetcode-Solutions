/**
 *      PROBLEM: REARRANGE ARRAY ELEMENTS BY SIGN
 * 
 * Given an array `nums` of even length `n`, where half of the elements are 
 * positive and half are negative, rearrange the elements in an alternating
 * positive-negative order while maintaining their original relative order.
 * 
 * Example:
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 * 
 * Time Complexity: O(n) - We iterate through the array twice.
 * Space Complexity: O(n) - Extra space is used for left and right partitions.
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int left[] = new int[n / 2];  // Array to store negative numbers
        int right[] = new int[n / 2]; // Array to store positive numbers
        
        int j = 0, k = 0;
        
        // Separate positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                left[j++] = nums[i];
            } else {
                right[k++] = nums[i];
            }
        }
        
        j = 0;
        k = 0;
        int ans[] = new int[n];
        
        // Merge both arrays in alternating order
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans[i] = right[k++];
            } else {
                ans[i] = left[j++];
            }
        }
        
        return ans;
    }
}
