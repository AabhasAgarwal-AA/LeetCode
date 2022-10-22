class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){ 
                    if(dfs(grid, i, j))
                        count++;   
                }
            }
        }
        
        return count;
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1},{0, -1}};
    
    private boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;
        
        if(grid[i][j] == 1 || grid[i][j] == 2)
            return true;
        grid[i][j] = 2;
        
        boolean ans = true;
        for(int[] dir: dirs){
           ans = dfs(grid, i + dir[0], j + dir[1]) && ans;
        }
        return ans;
    }
}