/**
 *        PROBLEM: SINGLE ELEMENT IN A SORTED ARRAY
 * 
 * Given a sorted array `nums` where every element appears twice except 
 * for one element that appears only once, find and return the single element.
 * 
 * Example:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Time Complexity: O(log n) - We use binary search, reducing the search space by half each time.
 * Space Complexity: O(1) - No extra space is used.
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;

            // Ensure mid is even for correct pairing
            if (mid % 2 == 1) {
                mid--;
            }

            // If mid and mid+1 form a pair, move right half forward
            if (nums[mid] != nums[mid + 1]) {
                right = mid; // Unique element is in the left half
            } else {
                left = mid + 2; // Unique element is in the right half
            }
        }

        return nums[left]; // Left index will point to the single element
    }
}
