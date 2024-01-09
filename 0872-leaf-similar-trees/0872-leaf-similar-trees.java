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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        
        findDfs(root1,al1);
        findDfs(root2,al2);
        
        return al1.equals(al2);
    }
    
    private void findDfs(TreeNode node,List<Integer> al)
    {
        if(node==null)
        {
            return;
        }
        if(node.left==null && node.right==null)
        {
            al.add(node.val);
        }else{
            findDfs(node.left,al);
            findDfs(node.right,al);
        }
        
    } 
}