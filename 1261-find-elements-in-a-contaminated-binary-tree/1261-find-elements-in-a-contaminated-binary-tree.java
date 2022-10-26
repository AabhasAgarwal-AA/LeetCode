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
class FindElements {
    TreeNode node;
    public FindElements(TreeNode root) {
        node = root;
        node.val = 0;
    }
    
    public boolean find(int target) {
        return find(node, target);
    }
    private boolean find(TreeNode node, int tar){
        if(node == null)
            return false;
        if(node.val == tar)
            return true;
        
        if(node.left != null)
            node.left.val = 2 * node.val + 1;
        
        if(node.right != null)
            node.right.val = 2 * node.val + 2;
        
        return find(node.left, tar) || find(node.right, tar);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */