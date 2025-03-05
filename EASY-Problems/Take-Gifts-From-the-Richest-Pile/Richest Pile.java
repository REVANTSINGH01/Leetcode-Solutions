

/**
 *      TAKE GIFTS FROM THE RICHEST PILE
 *
 * Solution class to implement the pickGifts method.
 * The function modifies the highest gift value `k` times by replacing it with its square root.
 */
public class Solution {
    
    /**
     * Modifies the gift values `k` times by taking the highest value,
     * replacing it with its square root (floored), and then returning the sum.
     */
    public long pickGifts(int[] gifts, int k) {
        // Max-Heap to always process the largest element first
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all gifts to the max-heap
        for (int gift : gifts) {
            maxHeap.add((long) gift);
        }

        // Perform `k` operations of replacing max element with its floored square root
        while (k-- > 0 && !maxHeap.isEmpty()) {
            long maxGift = maxHeap.poll();
            maxHeap.add((long) Math.floor(Math.sqrt(maxGift)));
        }

        // Sum up remaining elements in the max-heap
        long totalSum = 0;
        while (!maxHeap.isEmpty()) {
            totalSum += maxHeap.poll();
        }

        return totalSum;
    }
}
