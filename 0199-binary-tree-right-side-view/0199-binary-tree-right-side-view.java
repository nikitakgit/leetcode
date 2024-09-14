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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        rightV(root,result,0);
        return result;
    }
    public void rightV(TreeNode curr,List<Integer> res,int currDepth)
    {
        if(curr==null) return;
        if(currDepth==res.size())
        {
            res.add(curr.val);
        }
        rightV(curr.right,res,currDepth+1);
        rightV(curr.left,res,currDepth+1);
    }
    
}