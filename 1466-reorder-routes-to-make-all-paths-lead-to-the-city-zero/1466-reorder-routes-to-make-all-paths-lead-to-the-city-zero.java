class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0], v = connections[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(-u);
        }
        
        
        boolean[] vis = new boolean[n];
        dfs(graph, vis, 0);
        return count;
    }
    private void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int v){
        vis[v] = true;
        
        List<Integer> nbrs = graph.get(v);
        
        for(int nbr  : nbrs){
            if(!vis[Math.abs(nbr)]){
                if(nbr > 0)
                    count++;
                dfs(graph, vis, Math.abs(nbr));
            }
        }
    }
}