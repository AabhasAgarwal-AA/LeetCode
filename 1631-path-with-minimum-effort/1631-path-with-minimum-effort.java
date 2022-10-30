class Solution {
    int[] par, rank;
    int find(int u){
        return par[u] == u ? u : (par[u] = find(par[u]));
    }
    void union(int a, int b){
        if(rank[a] < rank[b]){
            par[a] = b;
        }else if(rank[b] < rank[a]){
            par[b] = a;
        }else{
            par[b] = a;
            rank[a]++;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        if(heights.length == 1 && heights[0].length == 1)
            return 0;
        
        int n = heights.length, m = heights[0].length;
        
        par = new int[n * m];
        rank = new int[n * m];
        for(int i = 0; i < m * n; i++)
            par[i] = i;
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i < n - 1){
                    int diff = Math.abs(heights[i][j] - heights[i+1][j]);
                    list.add(new int[]{i * m + j, (i+1) * m + j, diff});
                }
                
                if(j < m -1){
                    int diff = Math.abs(heights[i][j] - heights[i][j+1]);
                    list.add(new int[]{i * m + j, i * m + (j+1), diff});
                }
            }
        }
        Collections.sort(list, (a, b)->a[2] - b[2]);
        for(int[] edge: list){
            int xpar = find(edge[0]);
            int ypar = find(edge[1]);
            
            if(xpar != ypar){
                union(xpar, ypar);
            }
            if(find(0) == find(m * n - 1))
                return edge[2];
        }
        return 0;
    }
}