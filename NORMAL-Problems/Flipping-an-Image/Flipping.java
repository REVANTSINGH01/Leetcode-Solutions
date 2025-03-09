/**
 *    LEETCODE PROBLEM: FLIPPING AN IMAGE
 *
 * Given a binary matrix `image`, first flip the image horizontally, 
 * then invert it (0s -> 1s and 1s -> 0s).
 * 
 * Example:
 * Input: [[1,1,0],
 *         [1,0,1],
 *         [0,0,0]]
 * Output: [[1,0,0],
 *          [0,1,0],
 *          [1,1,1]]
 * 
 * Approach:
 * 1. **Flip Horizontally** - Swap elements symmetrically in each row.
 * 2. **Invert** - XOR each element with `1` (bitwise NOT operation).
 * 
 * Time Complexity: O(n²) - We iterate through all elements in the matrix twice.
 * Space Complexity: O(1) - In-place transformation without extra space.
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int mask = 1; // Used for bitwise inversion (XOR operation)

        // Step 1: Flip the image horizontally (Reverse each row)
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image[0].length - 1 - j];
                image[i][image[0].length - 1 - j] = temp;
            }
        }

        // Step 2: Invert the image (0s -> 1s, 1s -> 0s using XOR operation)
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] ^= mask; // XOR with 1 to flip bits
            }
        }

        return image;
    }
}
