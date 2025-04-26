/**
 * ================================================
 * Problem: Simulate Instructions with Jumps and Adds
 * ================================================
 * 
 * You are given two arrays, `instructions` and `values`, both of size n.
 * 
 * Rules:
 * - Start at index 0 with score 0.
 * - If "add": Add values[i] to score and move to i + 1.
 * - If "jump": Move to i + values[i] without changing score.
 * - Stop if you move out of bounds or revisit an index.
 * 
 * Example:
 * instructions = ["jump","add","add","jump","jump","jump"]
 * values = [3,5,12,-1,-3,-5]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int len = values.length;
        int index = 0;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(index);

        while (index >= 0 && index < len) {
            if (instructions[index].equals("jump")) {
                index += values[index];
                
                // Check after jump
                if (index < 0 || index >= len || visited.contains(index)) {
                    break;
                }
                visited.add(index);
            } 
            else if (instructions[index].equals("add")) {
                score += values[index];
                index++;
                
                // Check after add
                if (index < 0 || index >= len || visited.contains(index)) {
                    break;
                }
                visited.add(index);
            }
        }
        
        return score;
    }
}
