/**
 * ================================================================
 *   LEETCODE PROBLEM: Count Primes (LC #204)
 * ================================================================
 * 
 * Count the number of prime numbers less than a non-negative number `n`.
 * 
 * ------------------------------------------------
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10: 2, 3, 5, 7.
 * 
 * Example 2:
 * Input: n = 0
 * Output: 0
 * 
 * Example 3:
 * Input: n = 1
 * Output: 0
 * 
 * ------------------------------------------------
 * Approach:
 * - Use the Sieve of Eratosthenes to mark non-prime numbers.
 * - Create a boolean array `isPrime` where `isPrime[i]` is true if `i` is prime.
 * - Start from 2, and for each prime, mark all its multiples as false.
 * - Count the number of true values in the array to get the total primes.
 * 
 * ------------------------------------------------
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 */

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        // Edge case: no primes less than 2
        if (n <= 2) return 0;

        // Step 1: Assume all numbers are prime initially
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = isPrime[1] = false;

        int count = 0;

        // Step 2: Sieve of Eratosthenes
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;

                // Mark multiples of i as non-prime
                for (long j = (long) i * i; j < n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        return count;
    }
}
