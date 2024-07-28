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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode buildTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd, Map<Integer,Integer> inMap)
    {
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(pre[preStart]);
        int inRoot=inMap.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(pre,preStart+1,preStart+numsLeft,in,inStart,inRoot+1,inMap);
        root.right=buildTree(pre,preStart+numsLeft+1,preEnd,in,inRoot+1,inEnd,inMap);
        
        return root;
    }
}