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
class Tuple{
    TreeNode node;
    int vertical;
    int level;
    
    Tuple(TreeNode node,int vertical,int level)
    {
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty())
        {
            Tuple t=q.poll();
            TreeNode node=t.node;
            int ver=t.vertical;
            int level=t.level;
            if(!map.containsKey(ver))
            {
                map.put(ver,new TreeMap<>());
            }
            if(!map.get(ver).containsKey(level))
            {
                map.get(ver).put(level,new PriorityQueue<>());
            }
            map.get(ver).get(level).offer(node.val);
            if(node.left!=null)
            {
                q.offer(new Tuple(node.left,ver-1,level+1));
            }
            if(node.right!=null)
            {
                q.offer(new Tuple(node.right,ver+1,level+1));
            } 
        }
        
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> e:map.values())
        {
           list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:e.values())
            {
                while(!nodes.isEmpty())
                {
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}