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
    private Map<Integer,Integer> map=new HashMap<>();
    private void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inOrder(root.right);
    }
    
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int maxi=0;
        
        for(int value:map.values())
        {
            maxi=Math.max(maxi,value);
        }
        
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==maxi)
            {
                ans.add(entry.getKey());
            }
        }
        
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            res[i]=ans.get(i);
        }
        return res;
    }
}

  