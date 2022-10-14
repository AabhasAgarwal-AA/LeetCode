class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int len = 0;
        for(int num: nums){
            if(num == 1){ 
                len++;
                res = Math.max(res, len);   
            }else{ 
                len = 0;
            }
        }
        return res;
    }
}