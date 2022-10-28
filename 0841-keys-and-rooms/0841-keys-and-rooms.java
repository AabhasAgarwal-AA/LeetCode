class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms.get(0), 0, rooms, vis);
        
        for(int i = 0; i < vis.length; i++){
            if(!vis[i])
                return false;
        }
        return true;
    }
    
    private void dfs(List<Integer> keyInRoom, int room, List<List<Integer>> rooms, boolean[] vis){
        vis[room] = true;
        
        for(int key: keyInRoom){
            if(!vis[key])
                dfs(rooms.get(key), key, rooms, vis);
        }
    }
}