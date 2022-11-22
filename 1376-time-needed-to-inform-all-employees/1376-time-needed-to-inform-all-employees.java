class Solution {
    class Pair{
        int vtx;
        int time;
        Pair(int vtx, int time){
            this.vtx = vtx;
            this.time = time;
        }
    }
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
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(headID, 0));
        int maxTime = 0;
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Pair rem = que.removeFirst();
                maxTime = Math.max(maxTime, rem.time);
                
                int timeForSub = informTime[rem.vtx];
                for(int subOrd: graph[rem.vtx]){
                    que.addLast(new Pair(subOrd, timeForSub + rem.time));
                }
            }
        }
        
        return maxTime;
    }    
}