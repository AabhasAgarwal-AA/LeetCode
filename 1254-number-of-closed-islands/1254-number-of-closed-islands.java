class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j))
                        count++;
                }
            }
        }
        
        return count;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean dfs(int[][] grid, int i, int j){
        if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)
            return false;
        
        if(grid[i][j] == 1 || grid[i][j] == 2)
            return true;
        
        grid[i][j] = 2;
        boolean res = true;
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(grid[r][c] == 0){ 
                res = dfs(grid, r, c) && res;
            }
        }
        return res;
    }
}