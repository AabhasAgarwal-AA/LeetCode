class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] parent = new int[n];
        boolean[] vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < edges.size(); i++){
            List<Integer> edge = edges.get(i);
            int u = edge.get(0), v = edge.get(1);
            
            if(vis[v])
                continue;
            vis[v] = true;
            
            int p1 = findPar(u, parent);
            int p2 = findPar(v, parent);
            
            if(p1 != p2)
                parent[p2] = p1;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(parent[i] == i)
                list.add(i);
        }
        return list;
    }
    
    private int findPar(int u, int[] parent){
        return parent[u] == u ? u : (parent[u] = findPar(parent[u], parent));
    }
}