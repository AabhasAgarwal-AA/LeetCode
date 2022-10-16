class Solution {
    int range;
    Random r;
    HashMap<Integer, Integer> map;
    HashSet<Integer> invalid;
    
    public Solution(int n, int[] blacklist) {
        range = n - blacklist.length;
        r = new Random();
        map = new HashMap<>();
        invalid = new HashSet<>();
        
        for(int bl: blacklist)
            invalid.add(bl);
        
        int curr = range;
        for(int bl: blacklist){
            if(bl < range){
                while(invalid.contains(curr))
                    curr++;
                
                map.put(bl, curr);
                curr++;
            }
        }
    }
    
    public int pick() {
        int res = r.nextInt(range);
        if(map.containsKey(res))
            res = map.get(res);
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */