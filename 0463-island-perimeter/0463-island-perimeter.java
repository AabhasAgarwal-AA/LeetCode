class Solution {
    int temp;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        temp = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    temp = 0;
                    for(int[] d : dir) {
                        int r = i + d[0];
                        int c = j + d[1];
                        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) temp++;
                    }
                    ans += (4 - temp);
                }
            }
        }
        return ans;
    }
}