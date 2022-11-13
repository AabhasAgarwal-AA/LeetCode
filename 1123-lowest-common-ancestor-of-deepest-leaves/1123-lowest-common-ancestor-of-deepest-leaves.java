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
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair dfspair = dfs(root, 0);
        return dfspair.node;        
    }
    private Pair dfs(TreeNode node, int depth){
        if(node == null)
            return new Pair(null, depth);
        
        Pair left = dfs(node.left, depth + 1);
        Pair right = dfs(node.right, depth + 1);
        
        if(left.depth == right.depth){
            return new Pair(node, left.depth);
        }else if(left.depth > right.depth){
            return left;
        }
        return right;
    }
}