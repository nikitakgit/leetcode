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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,root.val,root.val);
    }
    public int helper(TreeNode root,int mn,int mx)
    {
        if(root==null)
        {
            return mx-mn;
        }
        
        mx=Math.max(mx,root.val);
        mn=Math.min(mn,root.val);
        
        int leftDiff=helper(root.left,mn,mx);
        int rightDiff=helper(root.right,mn,mx);
        
        return Math.max(leftDiff,rightDiff);
        
    }
}