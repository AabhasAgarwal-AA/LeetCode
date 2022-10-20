class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] prefixCount = new int[102];
        int[] res = new int[nums.length];
        
        for(int val: nums){
            prefixCount[val + 1]++;
        }
        
        for(int i = 1; i < 102; i++){
            prefixCount[i] += prefixCount[i-1];
        }
        
        for(int i = 0; i < nums.length; i++){
            res[i] = prefixCount[nums[i]];
        }
        return res;
    }
}