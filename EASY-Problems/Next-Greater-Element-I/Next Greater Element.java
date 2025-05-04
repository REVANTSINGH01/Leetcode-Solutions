/**
 * ========================================================
 * LeetCode Problem: 496. Next Greater Element I
 * ========================================================
 *
 * Description:
 * Given two arrays nums1 and nums2, where nums1 is a subset of nums2,
 * return an array consisting of the next greater element of each element in nums1
 * from their corresponding position in nums2.
 *
 * Approach:
 * 1. Use a monotonic decreasing stack to find the next greater element for each number in nums2.
 * 2. Store the result in a HashMap for quick lookup.
 * 3. Iterate over nums1 and retrieve next greater elements from the map, or -1 if not present.
 *
 * Time Complexity: O(n + m) where n = nums1.length, m = nums2.length
 * Space Complexity: O(m) for stack and map
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to fill the map with next greater elements
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num); // Found next greater for the top of stack
            }
            stack.push(num);
        }

        // Prepare result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Retrieve next greater from map or -1 if not found
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
