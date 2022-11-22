class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            int Manager = manager[i];
            if(Manager != -1){
                graph[Manager].add(i);
            }
        }
        
        return dfs(graph, headID, informTime);
    }
    
    private int dfs(ArrayList<Integer>[] graph, int src, int[] informTime){
        int childTime = 0;
        
        for(int subOrd: graph[src]){
            childTime = Math.max(childTime, dfs(graph, subOrd, informTime));
        }
        return childTime + informTime[src];
    }
}