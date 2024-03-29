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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] digits=new int[10];
        return dfs(root,digits);
    }
    
    private int dfs(TreeNode root,int[] digits)
    {
        if(root==null) return 0;
        
        digits[root.val]++;
        if(root.left==null && root.right==null)
        {
            int cnt=countOdd(digits);
            digits[root.val]--;
            return (cnt<=1) ? 1:0;
        }
        
        int leftCnt=dfs(root.left,digits);
        int rightCnt=dfs(root.right,digits);
        
        digits[root.val]--;
        return leftCnt+rightCnt;
        
    }
    public int countOdd(int[] digits)
    {
        int cnt=0;
        for(int i=1;i<10;i++)
        {
            if((digits[i] & 1)==1) cnt++;
        }
        return cnt;
    }
    
}

       
   