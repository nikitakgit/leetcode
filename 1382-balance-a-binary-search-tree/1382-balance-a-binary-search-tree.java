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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedEle=new ArrayList<>();
        inOrderTraversal(root,sortedEle);
        return buildBalancedBST(sortedEle,0,sortedEle.size()-1);
    }
    private void inOrderTraversal(TreeNode node,List<Integer> sortedEle)
    {
        if(node==null) return;
        inOrderTraversal(node.left,sortedEle);
        sortedEle.add(node.val);
        inOrderTraversal(node.right,sortedEle);
    }
    private TreeNode buildBalancedBST(List<Integer> ele,int s,int e)
    {
        if(s>e) return null;
        int mid=s+(e-s)/2;
        TreeNode node=new TreeNode(ele.get(mid));
        node.left=buildBalancedBST(ele,s,mid-1);
        node.right=buildBalancedBST(ele,mid+1,e);
        return node;
    }
}