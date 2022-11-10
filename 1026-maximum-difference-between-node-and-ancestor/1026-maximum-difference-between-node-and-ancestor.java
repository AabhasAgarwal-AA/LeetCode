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
    int maxDiff = -(int)1e9;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxDiff;
    }
    
    private void dfs(TreeNode root, int max, int min){
        if(root == null)
            return;
        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        if(Math.abs(max - min) > maxDiff)
            maxDiff = Math.abs(max - min);
        
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}