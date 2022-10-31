class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int res = nums[0];
        int positive = 1;
        int negative = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                // positive value
                positive = Math.max(positive * nums[i], nums[i]);
                negative = negative * nums[i];
            }else{
                // negative value
                int temp = negative;
                negative = Math.min(nums[i], nums[i] * positive);
                positive = temp * nums[i];
            }
            res = Math.max(res, positive);
            res = Math.max(res, negative);
        }
        return res;
    }
}