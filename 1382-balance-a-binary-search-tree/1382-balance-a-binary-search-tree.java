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
    int[] height = new int[(int)1e5 + 1];
    public TreeNode balanceBST(TreeNode root) {
        return reConstruct(root);
    }
    
    private TreeNode reConstruct(TreeNode root){
        if(root == null)
            return null;
        root.left = reConstruct(root.left);
        root.right = reConstruct(root.right);
        
        return getRotation(root);
    }
    
    private TreeNode getRotation(TreeNode root){
        updateHeight(root);
        if(getBal(root) >= 2){
            if(getBal(root.left) >= 1){
                return rightRotation(root);
            }else{
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }else if(getBal(root) <= -2){
            if(getBal(root.right) <= -1){
                return leftRotation(root);
            }else{
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        return root;
    }
    
    private void updateHeight(TreeNode root){
        int lh = root.left != null ? height[root.left.val] : -1;
        int rh = root.right != null ? height[root.right.val] : -1;
        
        height[root.val] = Math.max(lh, rh) + 1;
    }
    
    private int getBal(TreeNode root){
        int lh = root.left != null ? height[root.left.val] : -1;
        int rh = root.right != null ? height[root.right.val] : -1;
        
        return lh - rh;
    }
    
    private TreeNode rightRotation(TreeNode a){
        TreeNode b = a.left;
        TreeNode bKaRight = b.right;
        
        b.right = a;
        a.left = bKaRight;
        
        b.right = getRotation(a);
        return getRotation(b);
    }
    
    private TreeNode leftRotation(TreeNode a){
        TreeNode b = a.right;
        TreeNode bKaLeft = b.left;
        
        b.left = a;
        a.right = bKaLeft;
        
        b.left = getRotation(a);
        return getRotation(b);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}