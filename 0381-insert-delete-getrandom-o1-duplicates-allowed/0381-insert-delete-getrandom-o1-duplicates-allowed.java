class RandomizedCollection {
    Random r;
    ArrayList<Integer> list;
    HashMap<Integer, HashSet<Integer>> map;
    public RandomizedCollection() {
        r = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean res = false;
        if(!map.containsKey(val)){
            res = true;
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return res;
            
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int lidx = list.size() - 1;
        int lval = list.get(lidx);
        
        if(val != lval){
            int vidx = map.get(val).iterator().next();
            swap(vidx, lidx);
        }
        
        list.remove(lidx);
        map.get(val).remove(lidx);
        if(map.get(val).size() == 0)
            map.remove(val);
        
        return true;
    }
    private void swap(int i, int j){
        int ival = list.get(i);
        int jval = list.get(j);
        
        list.set(i, jval);
        list.set(j, ival);
        
        map.get(ival).remove(i);
        map.get(ival).add(j);
        map.get(jval).remove(j);
        map.get(jval).add(i);
    }
    
    public int getRandom() {
       int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */