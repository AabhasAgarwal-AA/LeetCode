class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer>[] map = new ArrayList[groupSizes.length + 1];
        for(int i = 0; i <= groupSizes.length; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < groupSizes.length; i++){
            int size = groupSizes[i];
            map[size].add(i);
            if(map[size].size() == size){
                res.add(map[size]);
                map[size] = new ArrayList<>();
            }
        }

        return res;
    }
}