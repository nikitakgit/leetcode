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
    int ans;
    public int helper(TreeNode root)
    {
        if(root==null) return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        ans+=Math.abs(l)+Math.abs(r);
        return (root.val-1)+l+r;
    }
    public int distributeCoins(TreeNode root) {
        ans=0;
        helper(root);
        return ans;
    }
}