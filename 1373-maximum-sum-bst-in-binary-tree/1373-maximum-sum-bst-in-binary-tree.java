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
        int sum = 0;
        int max = -(int)1e9;
        int min = (int)1e9;
    }
    int maxSum = -(int)1e8;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum > 0 ? maxSum : 0;
    }
    private Pair dfs(TreeNode root){
        if(root == null){
            Pair basep = new Pair();
            return basep;
        }
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        Pair rootp = new Pair();
        if(root.val > left.max && root.val < right.min){
            rootp.max = Math.max(root.val, right.max);
            rootp.min = Math.min(root.val, left.min);
            
            rootp.sum = root.val + left.sum + right.sum;
            maxSum = Math.max(rootp.sum, maxSum);
        }else{
            // can't pretend to be a BST 
            rootp.sum = Math.max(left.sum, right.sum);
            rootp.max = (int)1e9;
            rootp.min = -(int)1e9;
        }
        
        return rootp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}