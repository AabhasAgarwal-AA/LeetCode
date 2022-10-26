class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int val: nums)
            set.add(val);
        
        for(int val: nums){
            int rev = reverse(val);
            set.add(rev);
        }
        return set.size();
    }
    
    private int reverse(int val){
        int num = 0;
        
        while(val != 0){
            int rem = val % 10;
            num = num * 10 + rem;
            val = val / 10;
        }
        
        return num;
    }
}