/**
 * ============================================================================
 * LeetCode Problem: 1025 - Divisor Game
 * ============================================================================
 *
 * Problem Statement:
 * Alice and Bob take turns playing a game, with Alice starting first.
 * Initially, there is a number `n` on the chalkboard.
 * On each player's turn, they choose an `x` such that:
 *  - 0 < x < n
 *  - n % x == 0 (x is a divisor of n)
 * They then replace the number `n` with `n - x`.
 * The player who cannot make a move loses the game.
 *
 * Return true if Alice wins the game, assuming both players play optimally,
 * otherwise return false.
 *
 * Constraints:
 * - 1 <= n <= 1000
 *
 * Approach:
 * Alice will win if and only if `n` is even.
 * - If `n` is even, she can always subtract 1 (an odd number),
 *   giving Bob an odd number on his turn.
 * - Every time Bob gets an odd number, any valid move he makes
 *   results in an even number for Alice again.
 * - Eventually, Bob will be stuck with 1 (no move), and Alice wins.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
