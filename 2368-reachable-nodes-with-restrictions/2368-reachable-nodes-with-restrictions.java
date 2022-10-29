class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int val: restricted)
            set.add(val);
        
        boolean[] vis = new boolean[n];
        
        return dfs(graph, set, 0, vis);
    }
    
    private int dfs(ArrayList<Integer>[] graph, HashSet<Integer> set, int v, boolean[] vis){
        vis[v] = true;
        int reachableNodes = 1;
        
        List<Integer> nbrs = graph[v];
        for(int nbr: nbrs){
            if(!vis[nbr] && !set.contains(nbr)){
                reachableNodes += dfs(graph, set, nbr, vis);
            }
        }
        
        return reachableNodes;
    }
}