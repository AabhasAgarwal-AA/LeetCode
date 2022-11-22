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
    int maxTime = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return maxTime;
    }
    private void burnTree(TreeNode root, TreeNode blockNode, int time){
        if(root == null || root == blockNode)
            return;
        
        maxTime = Math.max(time, maxTime);
        
        burnTree(root.left, blockNode, time + 1);
        burnTree(root.right, blockNode, time + 1);
    }
    
    private int dfs(TreeNode root, int start){
        if(root == null)
            return -1;
        if(root.val == start){
            burnTree(root, null, 0);
            return 1;
        }
        
        int leftTime = dfs(root.left, start);
        if(leftTime != -1){
            burnTree(root, root.left, leftTime);
            return leftTime + 1;
        }
        
        int rightTime = dfs(root.right, start);
        if(rightTime != -1){
            burnTree(root, root.right, rightTime);
            return rightTime + 1;
        }
        
        return -1;
    }
}