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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map =new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        dfs(root, map, list);
        return list;
    }
    
    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> list){
        if(root == null)
            return "";
        
        String left = dfs(root.left, map, list);
        String right = dfs(root.right, map, list);
        
        String curr = root.val + " " + left + " " + right;
        if(map.getOrDefault(curr, 0) == 1){
            list.add(root);
        }
        
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        
        return curr;
    }
}