/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 public int countPairs(TreeNode root, int distance) {
        int[] count = new int[1];  // Array to hold the count as we need to update it in DFS
        dfs(root, distance, count);
        return count[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] count) {
        if (node == null) return new int[distance + 1];
        
        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1;
            return leafDist;
        }
        
        int[] leftDist = dfs(node.left, distance, count);
        int[] rightDist = dfs(node.right, distance, count);
        
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    count[0] += leftDist[i] * rightDist[j];
                }
            }
        }
        
        int[] leafDist = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            leafDist[i + 1] = leftDist[i] + rightDist[i];
        }
        
        return leafDist;
    }
}