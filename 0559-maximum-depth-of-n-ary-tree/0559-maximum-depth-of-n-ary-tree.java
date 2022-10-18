/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return 0;
        
        int myHeight = 1;
        for(Node node: root.children){
            int childHeight = height(node);
            myHeight = Math.max(myHeight, childHeight + 1);
        }
        return myHeight;
    }
}