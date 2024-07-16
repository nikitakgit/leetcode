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
    public boolean find(TreeNode n,int val,StringBuilder sb)
    {
        if(n.val==val) return true;
        if(n.left!=null && find(n.left,val,sb)) sb.append("L");
        else if(n.right!=null && find(n.right,val,sb)) sb.append("R");
        return sb.length()>0;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s=new StringBuilder();
        StringBuilder d=new StringBuilder();
        find(root,startValue,s);
        find(root,destValue,d);
        
        int commonPathLength=0;
        int maxi=Math.min(s.length(),d.length());
        while(commonPathLength<maxi && s.charAt(s.length()-commonPathLength-1)==d.charAt(d.length()-commonPathLength-1))
        {
            commonPathLength++;
        }
        
        return "U".repeat(s.length()-commonPathLength)+d.reverse().toString().substring(commonPathLength);
    }
}
