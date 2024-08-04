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
    int maxD=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia(root);
        return maxD;
    }
    private int maxDia(TreeNode root)
    {
        if(root==null) return 0;
        int lh=maxDia(root.left);
        int rh=maxDia(root.right);
        
        int curD=lh+rh;
        maxD=Math.max(maxD,curD);
        return 1+Math.max(lh,rh);
    }
}