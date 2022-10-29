class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] conn: connections){
            int u = conn[0], v = conn[1];
            graph[u].add(v);
            graph[v].add(-u);
        }
        boolean[] vis = new boolean[n];
        dfs(graph, vis, 0);
        return count;
    }
    
    private void dfs(ArrayList<Integer>[] graph, boolean[] vis, int v){
        vis[v] = true;
        
        List<Integer> nbrs = graph[v];
        
        for(int nbr: nbrs){
            if(!vis[Math.abs(nbr)]){
                if(nbr > 0)
                    count++;
                dfs(graph, vis, Math.abs(nbr));
            }
        }
    }
}