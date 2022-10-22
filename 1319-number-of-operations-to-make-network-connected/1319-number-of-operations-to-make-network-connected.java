class Solution {
    int[] par, rank;
    void union(int xl, int yl){
        if(rank[xl] < rank[yl]){
            par[xl] = yl;
        }else if(rank[xl] > rank[yl]){
            par[yl] = xl;
        }else{
            par[xl] = yl;
            rank[yl]++;
        }
    }
    
    int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length)
            return -1;
        
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int[] connection : connections){
            int u = connection[0], v = connection[1];
            
            int p1 = findPar(u), p2 = findPar(v);
            if(p1 != p2){
                union(p1, p2);
                // par[p2]= p1;
            }
        }
        
        int components = 0;
        for(int i = 0; i < n; i++){
            int p = findPar(i);
            if(i == p)
                components++;
        }
        return components - 1;
    }
}