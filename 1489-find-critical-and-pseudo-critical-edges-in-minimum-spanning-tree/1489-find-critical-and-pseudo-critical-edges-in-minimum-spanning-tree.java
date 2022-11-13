class Solution {
    class unionFind{
        int[] p, r;
        int comps = 0;
        unionFind(int n){ // constructor
            p = new int[n];
            r = new int[n];
            comps = n;
            for(int i = 0; i < p.length; i++){
                p[i] = i;
                r[i] = 0;
            }
        }
        int find(int x){
            if(p[x]== x)
                return x;
            else{
                p[x] = find(p[x]);
                return p[x];
            }
        }
        boolean union(int X, int Y){
            int x = find(X);
            int y = find(Y);
            if(x == y)
                return false;
            
            if(r[x] < r[y]){
                p[x] = y;
            }else if(r[y] < r[x]){
                p[y] = x;
            }else{
                p[y] = x;
                r[x]++;
            }
            comps--;
            return true;
        }
        boolean isConnected(){
            return comps == 1;
        }
    }
    
    class Edge implements Comparable<Edge>{
        int u, v, wt;
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Edge o){
            return this.wt - o.wt;
        }
    }
    
    private int buildMST(int n, int[][] edges, int[] edgeToSkip, int[] edgeToPick){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int[] edge: edges){
            if(edge == edgeToSkip)
                continue;
            else if(edge == edgeToPick)
                continue;
            
            int u = edge[0], v = edge[1], wt = edge[2];
            pq.add(new Edge(u, v, wt));
        }
        
        unionFind uf = new unionFind(n);
        int cost = 0;
        if(edgeToPick != null){
            uf.union(edgeToPick[0], edgeToPick[1]);
            cost += edgeToPick[2];
        }
        while(pq.size() > 0){
            Edge rem = pq.remove();
            if(uf.union(rem.u, rem.v) == true)
                cost += rem.wt;
        }
        if(uf.isConnected() == true)
            return cost;
        
        return Integer.MAX_VALUE;
    } 

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int mstCost = buildMST(n, edges, null, null);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pcritical = new ArrayList<>();
        
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int mstCostWithoutEdge = buildMST(n, edges, edge, null);
            
            if(mstCostWithoutEdge > mstCost)
                critical.add(i);
            else{
                int mstCostWithEdge = buildMST(n, edges, null, edge);
                
                if(mstCostWithEdge > mstCost){
                    // redundant
                }else{
                    pcritical.add(i);
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pcritical);
        return res;
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}