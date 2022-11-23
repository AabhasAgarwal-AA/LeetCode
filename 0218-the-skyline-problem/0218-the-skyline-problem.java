class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int ht;
        public Pair(int x, int ht){
            this.x = x;
            this.ht = ht;
        }
        public int compareTo(Pair other){
            if(this.x != other.x)
                return this.x - other.x;
            else
                return this.ht - other.ht;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++){
            int startPoint = buildings[i][0];
            int endPoint = buildings[i][1];
            int ht = buildings[i][2];
            
            list.add(new Pair(startPoint, -ht));
            list.add(new Pair(endPoint, ht));
        }
        Collections.sort(list);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int currHt = 0;
        pq.add(0);
        
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).x;
            int ht = list.get(i).ht;
            
            if(ht < 0)
                pq.add(-ht);
            else
                pq.remove(ht);
            
            if(currHt != pq.peek()){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());
                
                ans.add(temp);
                currHt = pq.peek();
            }
        }
        
        return ans;
    }
}