class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        boolean[] set = new boolean[256];
        int j = -1;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(set[ch] == true){
                while(j < i){
                    j++;
                    char chr = s.charAt(j);
                    set[chr] = false;
                    if(chr == ch)
                        break;
                }
            }
            set[ch] = true;
            res = Math.max(res, i - j);
        }
        return res;
    }
}