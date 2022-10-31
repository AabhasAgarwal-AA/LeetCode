class Solution {
    public int singleNumber(int[] nums) {
        int m3x = -1;
        int m3xp1 = 0;
        int m3xp2 = 0;
        
        for(int val: nums){
            int cw3x = val & m3x;
            int cw3xp1 = val & m3xp1;
            int cw3xp2 = val & m3xp2;
            
            m3x = m3x & ~cw3x;
            m3xp1 = m3xp1 | cw3x;
            
            m3xp1 = m3xp1 & ~cw3xp1;
            m3xp2 = m3xp2 | cw3xp1;
            
            m3xp2 = m3xp2 & ~cw3xp2;
            m3x = m3x | cw3xp2;
        }
        
        return m3xp1;
    }
}