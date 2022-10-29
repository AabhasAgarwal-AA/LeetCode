class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] inDegree = new int[n];
        int[][] isEdge = new int[n][n];
        for(int[] road: roads){
            int u = road[0], v = road[1];
            inDegree[u]++;
            inDegree[v]++;
            
            isEdge[u][v] = 1; // true
            isEdge[v][u] = 1;
        }
        int maxEdges = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                maxEdges = Math.max(maxEdges, inDegree[i] + inDegree[j] - isEdge[i][j]);
            }
        }
        
        return maxEdges;
    }
}