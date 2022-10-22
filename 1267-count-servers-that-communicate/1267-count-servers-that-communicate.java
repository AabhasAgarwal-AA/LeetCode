class Solution {
    public int countServers(int[][] grid) {
        int total = 0;
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    total++;
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(rowCount[i] == 1 && colCount[j] == 1){
                        total--;
                    }
                }
            }
        }
        
        
        return total;
    }
}