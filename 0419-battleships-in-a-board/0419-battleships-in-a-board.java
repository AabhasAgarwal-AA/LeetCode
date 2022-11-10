class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){ 
                    count++;
                    dfs(board, i, j, dirs);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] board, int i, int j, int[][] dirs){
        board[i][j] = '.';
        
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'X'){
                dfs(board, r, c, dirs);
            }
        }
    }
}