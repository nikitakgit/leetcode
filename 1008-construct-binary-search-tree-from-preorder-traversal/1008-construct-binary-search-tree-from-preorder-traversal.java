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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode helper(int[] pre,int bound,int[] a)
    {
        if(a[0]==pre.length || pre[a[0]]>bound) return null;
        TreeNode root=new TreeNode(pre[a[0]++]);
        root.left=helper(pre,root.val,a);
        root.right=helper(pre,bound,a);
        return root;
    }
}