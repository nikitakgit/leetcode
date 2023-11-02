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
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return res;
    }
    
    private int[] postOrder(TreeNode node)
    {
        if(node==null)
        {
            return new int[]{0,0};
        }
        int[] left=postOrder(node.left);
        int[] right=postOrder(node.right);
        
        int totalSum=left[0]+right[0]+node.val;
        int totalCount=1+left[1]+right[1];
        res+=(node.val==totalSum/totalCount?1:0);
        
        return new int[]{totalSum,totalCount};
    }
}

   

    

    