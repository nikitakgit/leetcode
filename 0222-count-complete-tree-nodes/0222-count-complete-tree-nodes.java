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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftH=leftHeight(root);
        int rightH=rightHeight(root);
        if(leftH==rightH) return ((2<<(leftH))-1);
        else return countNodes(root.left)+countNodes(root.right)+1;
    }
    public int leftHeight(TreeNode root)
    {
        int cnt=0;
        while(root.left!=null)
        {
            cnt++;
            root=root.left;
        }
        return cnt;
    }
    public int rightHeight(TreeNode root)
    {
        int cnt=0;
        while(root.right!=null)
        {
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}