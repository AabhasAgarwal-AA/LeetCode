class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int n = grid.length;
        int m = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            int i1 = a / m, j1 = a % m;
            int i2 = b / m, j2 = b % m;
            
            return grid[i1][j1] - grid[i2][j2];
        });
        
        boolean[][] vis = new boolean[n][m];
        pq.add(0);
        vis[0][0] = true;
        int minHeight = 0;
        
        while(pq.size() != 0){
            int idx = pq.remove();
            int i = idx / m, j = idx % m;
            int height = grid[i][j];
            
            minHeight = Math.max(minHeight, height);
            
            if(i == n - 1 && j == m - 1)
                break;
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                
                if(r >= 0 && r < n && c >= 0 && c < m && !vis[r][c]){
                    vis[r][c] = true;
                    pq.add(r * m + c);
                }
            }
        }
        
        return minHeight;
    }
}