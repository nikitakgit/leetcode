/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> parent_track)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            if(cur.left!=null)
            {
                parent_track.put(cur.left,cur);
                q.offer(cur.left);
            }
            if(cur.right!=null)
            {
                parent_track.put(cur.right,cur);
                q.offer(cur.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        markParent(root,parent_track);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        vis.put(target,true);
        int cur_level=0;
        while(!q.isEmpty())
        {
           int size=q.size();
            if(cur_level==k) break;
            cur_level++;
            for(int i=0;i<size;i++)
            {
                TreeNode cur=q.poll();
                if(cur.left!=null && vis.get(cur.left)==null)
                {
                    q.offer(cur.left);
                    vis.put(cur.left,true);
                }
                if(cur.right!=null && vis.get(cur.right)==null)
                {
                    q.offer(cur.right);
                    vis.put(cur.right,true);
                }
                if(parent_track.get(cur)!=null && vis.get(parent_track.get(cur))==null)
                {
                    q.offer(parent_track.get(cur));
                    vis.put(parent_track.get(cur),true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            ans.add(cur.val);
        }
        return ans;
    }
}