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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, limit, 0);
    }
    private TreeNode dfs(TreeNode root, int limit, int sum){
        if(root == null)
            return null;
        
        if(root.left == null && root.right == null){
            if(sum + root.val < limit)
                return null; 
            return root;
        }
        
        root.left = dfs(root.left, limit, sum + root.val);
        root.right = dfs(root.right, limit, sum + root.val);
        
        if(root.left == null && root.right == null)
            return null;
        
        return root;
    }
}