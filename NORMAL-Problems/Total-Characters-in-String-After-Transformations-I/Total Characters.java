// Leetcode-style solution for: Length After Transformations
// Problem Summary:
// - Transform a string `t` times based on rules:
//     - If character == 'z' → replace with "ab"
//     - Else → shift to next character
// - Return final length modulo 10^9 + 7

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;

        // Frequency array for 'a' to 'z'
        int[] freq = new int[26];

        // Initialize frequency count from the input string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Apply the transformation `t` times
        while (t-- > 0) {
            int[] nextFreq = new int[26];
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) continue;

                if (i == 25) {
                    // 'z' → "ab"
                    nextFreq[0] = (nextFreq[0] + freq[25]) % MOD; // 'a'
                    nextFreq[1] = (nextFreq[1] + freq[25]) % MOD; // 'b'
                } else {
                    // shift to next character
                    nextFreq[i + 1] = (nextFreq[i + 1] + freq[i]) % MOD;
                }
            }
            freq = nextFreq; // update frequencies for next transformation
        }

        // Calculate total length of final string
        int totalLength = 0;
        for (int count : freq) {
            totalLength = (totalLength + count) % MOD;
        }

        return totalLength;
    }
}
