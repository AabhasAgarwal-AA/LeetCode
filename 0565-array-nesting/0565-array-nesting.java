class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] vis = new boolean[nums.length];
        
        for(int val: nums){
            int count = 0;
            while(vis[val] == false){
                count++;
                vis[val] = true;
                val = nums[val];
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
}