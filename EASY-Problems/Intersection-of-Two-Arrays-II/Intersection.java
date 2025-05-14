// ✅ GitHub-Ready Java Solution
// Problem: Intersection of Two Arrays II
// Approach: Use two hashmaps to count frequencies and find minimum matches
// Time Complexity: O(n + m) where n = nums1.length, m = nums2.length
// Space Complexity: O(n + m) for storing frequency maps

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Frequency maps for both arrays
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        // Count frequencies for nums1
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        // Count frequencies for nums2
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }

        // List to store intersection result
        List<Integer> intersection = new ArrayList<>();

        // Compare maps to get minimum common frequency
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int freq = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < freq; i++) {
                    intersection.add(key);
                }
            }
        }

        // Convert list to array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}
