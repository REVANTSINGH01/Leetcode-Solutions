/**
 *         PROBLEM: FLIP AN IMAGE 
 
 * Given a binary matrix `image`, first flip each row horizontally, 
 * then invert (complement) each element (0 -> 1, 1 -> 0).
 * 
 * Example 1:
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation:
 * - Flip each row: [[0,1,1], [1,0,1], [0,0,0]]
 * - Invert bits:   [[1,0,0], [0,1,0], [1,1,1]]
 * 
 * Example 2:
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 
 * Time Complexity: O(m * n) - Traverses each element once
 * Space Complexity: O(1) - Modifies input array in place
 */

public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int mask = 1; // XOR mask for flipping 0 to 1 and 1 to 0
        
        // Step 1: Flip each row horizontally
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length / 2; j++) {
                // Swap elements symmetrically
                int temp = image[i][j];
                image[i][j] = image[i][image[0].length - 1 - j];
                image[i][image[0].length - 1 - j] = temp;
            }
        }
        
        // Step 2: Invert each element
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] ^= mask; // Flip bits using XOR
            }
        }
        
        return image;
    }
}
