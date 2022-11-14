//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean pathFound(int[] par, int[][] rgraph){
        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean[] vis = new boolean[par.length];
        que.add(1);
        while(que.size() > 0){
            int rem = que.remove();
            if(vis[rem]){
                continue;
            }
            vis[rem] = true;
            if(rem == par.length - 1){
                return true;
            }
            for(int n = 1; n < rgraph.length; n++){
                if(rgraph[rem][n] > 0 && !vis[n]){
                    que.add(n);
                    par[n] = rem;
                }
            }
        }
        return false;
    }
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        int mflow = 0;
        int[][] graph = new int[N+1][N+1];
        int[][] rgraph = new int[N+1][N+1];
        
        for(ArrayList<Integer> edge: Edges){
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            
            graph[u][v] += w;
            graph[v][u] += w;
            
            rgraph[u][v] += w;
            rgraph[v][u] += w;
        }
        int[] par = new int[N+1];
        while(pathFound(par, rgraph)){
            int flow = Integer.MAX_VALUE;
            int v = N;
            while(v != 1){
                int pv = par[v];
                int price = rgraph[pv][v];
                if(price < flow){
                    flow = price;
                }
                v = pv;
            }
            v = N;
            while(v != 1){
                int pv = par[v];
                rgraph[pv][v] -= flow;
                rgraph[v][pv] += flow;
                v = pv;
            }
            mflow += flow;
        }
        return mflow;
    }
}