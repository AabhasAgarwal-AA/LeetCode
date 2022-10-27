class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(graph, 0, res, path);
        
        return res;
    }
    private void dfs(int[][] graph, int src, List<List<Integer>> res, List<Integer> path){
        if(src == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int node: graph[src]){
            path.add(node);
            dfs(graph, node, res, path);
            path.remove(path.size() - 1);
        }
    }
}