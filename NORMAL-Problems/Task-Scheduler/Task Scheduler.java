/**
 * ============================================================================
 * LeetCode Problem: 621 - Task Scheduler
 * ============================================================================
 *
 * Problem Statement:
 * You are given a char array `tasks`, representing tasks to do, where each task is 
 * represented by a capital letter. Each task takes 1 unit of time to complete, and 
 * each same task must be separated by at least `n` units of cooldown time.
 *
 * Objective:
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Approach:
 * 1. Count the frequency of each task using an array of size 26.
 * 2. Find the maximum frequency (`Max`) of any task.
 * 3. Count how many tasks have this maximum frequency (`k`).
 * 4. Use the formula: (Max - 1) * (n + 1) + k to compute the minimal required time.
 * 5. The result is the max between this calculated time and the total number of tasks (in case there are enough different tasks to fill idle slots).
 *
 * Time Complexity: O(N), where N is the number of tasks.
 * Space Complexity: O(1), since the frequency array is of fixed size 26.
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Step 1: Count task frequencies
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find max frequency
        int maxFreq = Arrays.stream(freq).max().getAsInt();

        // Step 3: Count how many tasks have the same max frequency
        int maxCount = 0;
        for (int count : freq) {
            if (count == maxFreq) maxCount++;
        }

        // Step 4: Calculate result using the task scheduling formula
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxCount;

        // Step 5: Return the maximum of calculated time or actual number of tasks
        return Math.max(emptySlots, tasks.length);
    }
}
