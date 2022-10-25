class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            if(!set.contains(val)){
                set.add(val);
            }else{
                res[0]++;
                set.remove(val);
            }
        }
        res[1] = set.size();
        return res;
    }
}