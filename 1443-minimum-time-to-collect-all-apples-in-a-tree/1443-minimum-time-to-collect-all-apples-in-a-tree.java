class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        int ans = dfs(tree, 0, hasApple, vis);
        return ans != 0 ? ans - 2 : ans;
    }
    
    private int dfs(ArrayList<Integer>[] tree, int src, List<Boolean> hasApple, boolean[] vis){
        int time = 0;
        vis[src] = true;
        
        for(int child: tree[src]){
            if(!vis[child])
                time += dfs(tree, child, hasApple, vis);
        }
        
        if(time != 0){
            return time + 2;
        }else if(hasApple.get(src)){
            return 2;
        }
        
        return 0;
    }
}