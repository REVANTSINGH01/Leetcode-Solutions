/**
 *       LEETCODE PROBLEM: TOP K FREQUENT ELEMENTS
 *
 * Given an integer array `nums` and an integer `k`, return the `k` most 
 * frequent elements. You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Approach:
 * - Use a HashMap to store the frequency of each element.
 * - Use a Min-Heap (PriorityQueue) to keep track of the top `k` frequent elements.
 * - If the heap size exceeds `k`, remove the element with the smallest frequency.
 * - Extract the keys from the heap to get the result.
 * 
 * Time Complexity: O(N log K) - Inserting into the heap takes logarithmic time.
 * Space Complexity: O(N + K) - For storing frequency map and heap of size `k`.
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map to store element counts
        Map<Integer,Integer> list = new HashMap<>();
        for(int num : nums) {
            list.put(num, list.getOrDefault(num, 0) + 1);
        }

        // Min-Heap to store the top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> temp = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Add elements to heap and maintain size k
        for(Map.Entry<Integer, Integer> val : list.entrySet()) {
            temp.add(val);
            if(temp.size() > k) temp.poll();
        }

        // Extract top k elements
        int result[] = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = temp.poll().getKey();
        }
        return result;
    }
}
