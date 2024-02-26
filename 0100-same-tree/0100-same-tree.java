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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrder(p,q);
    }
    public boolean inOrder(TreeNode p,TreeNode q)
    {
        if(p==null || q==null)
        {
            return p==q;
        }
        return (p.val==q.val && inOrder(p.left,q.left) && inOrder(p.right,q.right));
    }
}