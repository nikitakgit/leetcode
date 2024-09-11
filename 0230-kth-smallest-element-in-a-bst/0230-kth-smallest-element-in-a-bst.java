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
    

    private void inOrder(TreeNode root,int k,int[] cnt,int[] kthSmallest)
    {
        if(root==null || cnt[0]>=k) return;
        inOrder(root.left,k,cnt,kthSmallest);
        cnt[0]++;
        if(cnt[0]==k)
        {
            kthSmallest[0]=root.val;
            return;
        }
        inOrder(root.right,k,cnt,kthSmallest);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] cnt=new int[]{0};
        int[] kthSmallest=new int[]{Integer.MIN_VALUE};
        inOrder(root,k,cnt,kthSmallest);
        return kthSmallest[0];
    }
}
