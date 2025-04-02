/**
 * =========================================================
 *    LEETCODE PROBLEM: REVEAL CARDS IN INCREASING ORDER 
 * =========================================================
 * You are given an integer array `deck` where `deck[i]` represents a card value.
 * The deck is shuffled randomly, and you need to reveal the cards in increasing order
 * following a specific process:
 * 1. Pick the smallest card and place it at the top of an empty deck.
 * 2. Move the next smallest card to the bottom of the deck.
 * 3. Repeat until all cards are placed.
 *
 * Example 1:
 * Input: deck = [17,13,11,2,3,5,7]
 * Output: [2,13,3,11,5,17,7]
 *
 * Constraints:
 * - 1 <= deck.length <= 1000
 * - 1 <= deck[i] <= 10^6
 * - All deck[i] are unique.
 *
 * Approach:
 * - Sort the deck in increasing order.
 * - Use a queue to simulate the reveal process.
 * - Iterate through the sorted deck and assign values based on queue order.
 *
 * Time Complexity: O(n log n) - Due to sorting.
 * Space Complexity: O(n) - Extra space used for queue and result array.
 */

import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Queue<Integer> queue = new LinkedList<>();

        // Initialize queue with indices
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        // Sort deck in ascending order
        Arrays.sort(deck);

        // Result array to store the final deck order
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // Assign the smallest card to the correct position
            result[queue.poll()] = deck[i];
            
            // Move the next index to the bottom of the queue if queue is not empty
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return result;
    }
}
