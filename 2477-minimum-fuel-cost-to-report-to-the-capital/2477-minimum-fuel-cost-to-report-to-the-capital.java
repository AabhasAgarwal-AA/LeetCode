class Solution {
    long cost = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<Integer>[] graph = new ArrayList[roads.length + 1];
        for(int i = 0; i < roads.length + 1; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] road: roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        for(int node: graph[0]){
            dfs(graph, node, seats, 0);
        }
        return cost;
    }
    
    private int dfs(ArrayList<Integer>[] graph, int node, int seats, int prev){
        if(graph[node].size() == 1){
            cost += 1;
            return 1;
        }
        
        int ppl = 1;
        for(int subNode: graph[node]){
            if(subNode == prev || subNode == 0)
                continue;
            ppl += dfs(graph, subNode, seats, node);
        }
        
        cost += ppl / seats + (ppl % seats == 0 ? 0 : 1);
        return ppl;
    }
}