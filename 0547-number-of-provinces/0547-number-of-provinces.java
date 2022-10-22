class Solution {
    int[] par, rank;
    int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
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
        
    public int findCircleNum(int[][] isConnected) {
        par = new int[isConnected.length];
        rank = new int[isConnected.length];
        
        for(int i = 0; i < isConnected.length; i++){
            par[i] = i;
            rank[i] = 1;
        }
        int count = isConnected.length;
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    int xl = findPar(i);
                    int yl = findPar(j);
                    if(xl != yl){
                        union(xl, yl);
                        count--;
                    }
                }
            }
        }
        
        return count;
    }
}