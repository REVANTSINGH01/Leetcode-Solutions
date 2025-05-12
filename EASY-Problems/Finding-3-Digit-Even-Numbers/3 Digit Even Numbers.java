/**
 * ============================================================================
 * LeetCode Problem: 2094 - Finding 3-Digit Even Numbers
 * ============================================================================
 *
 * Problem Statement:
 * You are given an array `digits` (containing digits from 0–9). 
 * Return a sorted array of all unique 3-digit even numbers that can be formed 
 * using digits from the array exactly once for each digit used.
 *
 * Constraints:
 * - The number must be a 3-digit even number (i.e., range 100–999).
 * - Each digit can be used only as many times as it appears in the input.
 *
 * Approach:
 * 1. Count the frequency of each digit in the input array.
 * 2. Iterate through all 3-digit even numbers (100–999, step 2).
 * 3. For each candidate, check if it can be formed with the available digits.
 * 4. If yes, add it to the result list.
 *
 * Time Complexity: O(450) ≈ O(1), since we only check numbers from 100 to 998.
 * Space Complexity: O(1), result list holds at most ~450 numbers, and digit arrays are constant size.
 */

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCount = new int[10];

        // Step 1: Count frequency of each digit
        for (int digit : digits) {
            digitCount[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Iterate over all 3-digit even numbers
        for (int num = 100; num <= 999; num += 2) {
            int a = num / 100;         // Hundreds place
            int b = (num / 10) % 10;   // Tens place
            int c = num % 10;          // Units place

            int[] count = new int[10];
            count[a]++;
            count[b]++;
            count[c]++;

            // Step 3: Validate if the number can be formed from available digits
            if (count[a] <= digitCount[a] &&
                count[b] <= digitCount[b] &&
                count[c] <= digitCount[c]) {
                result.add(num);
            }
        }

        // Step 4: Convert result list to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
