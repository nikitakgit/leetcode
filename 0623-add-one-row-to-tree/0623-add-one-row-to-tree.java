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
    public TreeNode helper(TreeNode root,int val,int depth,int currdepth)
    {
        if(depth==1)
        {
            TreeNode n=new TreeNode(val);
            n.left=root;
            return n;
        }
        if(root==null)
        {
            return root;
        }
        if(currdepth==depth-1)
        {
            TreeNode leftnode=root.left;
            TreeNode rightnode=root.right;
            
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            
            root.left.left=leftnode;
            root.right.right=rightnode;
            
            return root;
        }
        
        helper(root.left,val,depth,currdepth+1);
        helper(root.right,val,depth,currdepth+1);
        
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return helper(root,val,depth,1);
    }
}
