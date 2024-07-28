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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
            
        }
        
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode buildTree(int[] in,int inStart,int inEnd,int[] post,int postStart,int postEnd,HashMap<Integer,Integer> hm)
    {
        if(postStart>postEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(post[postEnd]);
        int inRoot=hm.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(in,inStart,inRoot-1,post,postStart,postStart+numsLeft-1,hm);
        root.right=buildTree(in,inRoot+1,inEnd,post,postStart+numsLeft,postEnd-1,hm);
        
        return root;
    }
}