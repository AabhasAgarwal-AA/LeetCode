class Solution {
    int[] parent;
    int[] rank;
    
    int findPar(int u){
        return parent[u] == u ? u : (parent[u] = findPar(parent[u]));
    }
    
    void union(int p1, int p2){
        if(rank[p1] < rank[p2]){
            parent[p1] = p2;
        }else if(rank[p2] < rank[p1]){
            parent[p2] = p1;
        }else{
            parent[p1] = p2;
            rank[p2]++;
        }
    }
    
    public int removeStones(int[][] stones) {
        parent = new int[stones.length];
        rank = new int[stones.length];
        for(int i = 0; i < stones.length; i++)
            parent[i] = i;
        
        
        int isLands = stones.length;
        for(int i = 0; i < stones.length; i++){
            for(int j = i + 1; j < stones.length; j++){
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                
                if(stone1[0] == stone2[0] || stone1[1] == stone2[1]){
                    int p1 = findPar(i);
                    int p2 = findPar(j);
                    if(p1 != p2){
                        union(p1, p2);
                        isLands--;
                    }
                }
            }
        }

        return stones.length - isLands;
    }
}