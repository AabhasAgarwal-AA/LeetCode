class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k -1);
    }
    private int atMostK(int[] nums, int k){
        int res = 0;
        int j = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            while(i > j && map.size() > k){
                j++;
                if(map.get(nums[j]) == 1)
                    map.remove(nums[j]);
                else
                    map.put(nums[j], map.get(nums[j]) - 1);
            }
            
            res += (i - j);
        }
        
        return res;
    }
}