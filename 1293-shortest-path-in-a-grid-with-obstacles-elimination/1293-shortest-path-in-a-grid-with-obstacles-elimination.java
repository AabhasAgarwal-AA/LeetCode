class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        LinkedList<int[]> que = new LinkedList<>();
        que.addLast(new int[]{0, 0, 0});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        boolean[][][] vis = new boolean[n][m][k+1];
        int steps = 0;
        while(que.size() > 0){
            int size = que.size();
            while(size-- > 0){
                int[] rem = que.removeFirst();
                if(rem[0] == n - 1 && rem[1] == m - 1 && rem[2] <= k)
                    return steps;
                int x = rem[0], y = rem[1], currk = rem[2];
                if(vis[x][y][currk])
                    continue;
                vis[x][y][currk] = true;
                for(int[] dir: dirs){
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if(i >= 0 && j >= 0 && i < n && j < m){
                        int newK = rem[2] + grid[i][j];
                        if(newK > k)
                            continue;
                        que.addLast(new int[]{i, j, newK});
                        
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}







































// class Solution {
//     class pair{
//         int x;
//         int y;
//         int obs;
//         int time;
//         pair(int x, int y, int obs, int time){
//             this.x = x;
//             this.y = y;
//             this.obs = obs;
//             this.time = time;
//         }
//     }
//     public int shortestPath(int[][] grid, int k) {
//         int n = grid.length, m = grid[0].length;
//         LinkedList<pair> que = new LinkedList<>();
//         que.addLast(new pair(0, 0, k, 0));
//         boolean[][] vis = new boolean[n][m];
//         int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
//         while(que.size() > 0){
//             pair rem = que.removeFirst();
//             if(rem.x == n - 1 && rem.y == m - 1 && rem.obs >= 0)
//                 return rem.time;
//             int i = rem.x, j = rem.y;
//             if(vis[i][j])
//                 continue;
//             vis[i][j] = true;
//             for(int[] dir: dirs){
//                 int x = i + dir[0];
//                 int y = j + dir[1];
//                 if(x >= 0 && y >= 0 && x < n && y < m){
//                     int newK = rem.obs - grid[x][y];
//                     if(newK < 0)
//                         continue;
//                     que.addLast(new pair(x, y, newK, rem.time + 1));
//                 }
//             }
//         }
        
        
        
//         return -1;
//     }
// }