class Solution {
    int[] parent, low, disc;
    boolean[] vis;
    int time;
    private void dfs(int u, List<Integer>[] graph, List<List<Integer>> bridges){
        disc[u] = low[u] = time;
        vis[u] = true;
        time++;
        
        for(int nbr: graph[u]){
            if(parent[u] == nbr)
                continue;
            else if(vis[nbr] == true)
                low[u] = Math.min(low[u], disc[nbr]);
            else{
                parent[nbr] = u;
                dfs(nbr, graph, bridges);
                
                low[u] = Math.min(low[u], low[nbr]);
                if(low[nbr] > disc[u]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(nbr);
                    bridges.add(temp);
                }
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(List<Integer> edge: connections){
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        parent = new int[n];
        low = new int[n];
        disc = new int[n];
        time = 0;
        vis = new boolean[n];
        
        List<List<Integer>> bridges = new ArrayList<>();
        
        dfs(0, graph, bridges);
        return bridges;
    }
}