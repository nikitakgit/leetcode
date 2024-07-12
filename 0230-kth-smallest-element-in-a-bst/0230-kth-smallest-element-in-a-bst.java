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
    private class Counter {
        int count = 0;
        int kthSmallest = Integer.MIN_VALUE;
    }

    private void inorder(TreeNode root, Counter counter, int k) {
        if (root == null || counter.count >= k) return;
        
        inorder(root.left, counter, k);
        
        counter.count++;
        if (counter.count == k) {
            counter.kthSmallest = root.val;
            return;
        }
        
        inorder(root.right, counter, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inorder(root, counter, k);
        return counter.kthSmallest;
    }
}
