/**
 * =============================================================================
 * LeetCode Problem: 735 - Asteroid Collision
 * =============================================================================
 *
 * Problem Statement:
 * We are given an array `asteroids` of integers representing asteroids in a row.
 * Each asteroid moves at the same speed. The absolute value represents size,
 * and the sign represents direction (positive -> right, negative -> left).
 * 
 * If two asteroids meet, the smaller one explodes. If they are the same size,
 * both explode. Two asteroids moving in the same direction will never meet.
 * 
 * Return the state of the asteroids after all collisions.
 *
 * Constraints:
 * - 2 <= asteroids.length <= 10^4
 * - -1000 <= asteroids[i] <= 1000
 * - asteroids[i] != 0
 *
 * Approach:
 * - Use a stack to simulate asteroid collisions.
 * - Push positive (right-moving) asteroids directly.
 * - When a negative (left-moving) asteroid appears:
 *     - Check if it collides with top of stack (right-moving asteroid).
 *     - Resolve collisions until no more conflicts or asteroid explodes.
 * 
 * Time Complexity: O(n), where n is the number of asteroids.
 * Space Complexity: O(n), for the stack storing the result.
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean collided = false;

            // Resolve collisions: top is positive, current is negative
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop(); // Top explodes, continue checking
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // Both explode
                    collided = true;
                    break;
                } else {
                    collided = true; // Current explodes
                    break;
                }
            }

            if (!collided) {
                stack.push(asteroid);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        int index = 0;
        for (int num : stack) {
            result[index++] = num;
        }

        return result;
    }
}
