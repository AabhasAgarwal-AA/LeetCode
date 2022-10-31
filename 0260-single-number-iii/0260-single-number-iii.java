class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int val: nums)
            res = res ^ val;
        
        int rsb = (res & -res);
        
        int setA = 0, setB = 0;
        for(int val: nums){
            if((val & rsb) == 0){
                setA = setA ^ val;
            }else{
                setB = setB ^ val;
            }
        }
        
        return new int[]{setA, setB};
    }
}