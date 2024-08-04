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
    

    private void inorder(TreeNode root,int k,int[] cnt,int[] kthSmallest) {
        if(root==null || cnt[0]>=k) return;
        inorder(root.left,k,cnt,kthSmallest);
        cnt[0]++;
        if(cnt[0]==k)
        {
            kthSmallest[0]=root.val;
            return;
        }
        inorder(root.right,k,cnt,kthSmallest);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] cnt=new int[]{0};
        int[] kthSmallest=new int[]{Integer.MIN_VALUE};
        inorder(root,k,cnt,kthSmallest);
        return kthSmallest[0];
    }
}
