class Solution {
    class Pair{
        int bus;
        int count;
        Pair(int bus_, int count_){
            this.bus = bus_;
            this.count = count_;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
            return 0;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int bus = 0; bus < routes.length; bus++){
            for(int stop: routes[bus]){
                if(!map.containsKey(stop)){
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(bus);
            }
        }
        
        LinkedList<Pair> que = new LinkedList<>();
        for(int bus: map.get(source)){
            que.addLast(new Pair(bus, 1));
        }
        
        boolean[] vis = new boolean[routes.length];
        while(que.size() > 0){
            Pair rem = que.removeFirst();
            
            if(vis[rem.bus])
                continue;
            vis[rem.bus] = true;
            
            for(int stop: routes[rem.bus]){
                if(stop == target)
                    return rem.count;
            }
            
            for(int stop: routes[rem.bus]){
                for(int bus: map.get(stop)){
                    if(!vis[bus])
                        que.addLast(new Pair(bus, rem.count + 1));
                }
            }
        }
        return -1;
    }
}