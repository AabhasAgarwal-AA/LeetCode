class Solution {
    public int islandPerimeter(int[][] grid) {
        int isLand = 0, nbrs = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){ 
                    isLand++;
                
                    if(i < grid.length - 1 && grid[i+1][j] == 1)
                        nbrs++;

                    if(j < grid[i].length - 1 && grid[i][j+1] == 1)
                        nbrs++;
                }
            }
        }
        return (isLand * 4 - nbrs * 2);
    }
}