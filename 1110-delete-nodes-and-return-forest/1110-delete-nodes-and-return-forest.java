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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res=new ArrayList<>();
        if(root==null) return res;
        
        Set<Integer> toDS=new HashSet<>();
        for(int val:to_delete)
        {
            toDS.add(val);
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            TreeNode curNode=q.poll();
            if(curNode.left!=null)
            {
                q.offer(curNode.left);
                if(toDS.contains(curNode.left.val))
                {
                    curNode.left=null;
                }
            }
            if(curNode.right!=null)
            {
                q.offer(curNode.right);
                if(toDS.contains(curNode.right.val))
                {
                    curNode.right=null;
                }
            }
            if(toDS.contains(curNode.val))
            {
                if(curNode.left!=null)
                {
                    res.add(curNode.left);
                }
                if(curNode.right!=null)
                {
                    res.add(curNode.right);
                }
            }else if(res.isEmpty())
            {
                res.add(curNode);
            }
        }
        return res;
    }
}



