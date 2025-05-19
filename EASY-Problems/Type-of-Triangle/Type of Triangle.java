/**
 * ========================================
 * Leetcode Problem: Type of Triangle 
 * ========================================
 *
 * Problem Statement:
 * You are given an array of 3 positive integers representing the lengths of the 
 * sides of a triangle. Determine the type of triangle that can be formed.
 *
 * Return one of the following strings:
 * - "equilateral": All three sides are equal.
 * - "isosceles" : Exactly two sides are equal.
 * - "scalene"   : All three sides are different and can form a valid triangle.
 * - "none"      : The sides do not form a valid triangle.
 *
 * Constraints:
 * - The input array will always have exactly 3 integers.
 * - Each integer is in the range [1, 1000].
 *
 * Approach:
 * 1. Sort the array so that we can check the triangle inequality more easily.
 * 2. Check if the sum of the two smaller sides is greater than the largest side.
 *    - If not, return "none" (not a valid triangle).
 * 3. Check side equality to classify as equilateral, isosceles, or scalene.
 *
 * Time Complexity: O(1) – fixed array size (3 elements).
 * Space Complexity: O(1)
 */

class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the sides

        // Step 2: Check triangle inequality
        if (nums[0] + nums[1] <= nums[2]) {
            return "none"; // Not a valid triangle
        }

        // Step 3: Classify triangle by side equality
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
