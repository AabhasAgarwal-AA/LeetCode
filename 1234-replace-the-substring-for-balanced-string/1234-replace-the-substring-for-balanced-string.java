class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int r = n /4;
        
        int[] map1 = new int[26];
        for(char ch: s.toCharArray()){
            map1[ch - 'A']++;
        }
        
        int reqd = 0;
        for(char ch: "QWER".toCharArray()){
            if(map1[ch - 'A'] > r){
                map1[ch - 'A'] -= r;
                reqd += map1[ch - 'A'];
            }else{
                map1[ch - 'A'] = 0;
            }
        }
        if(reqd == 0)
            return 0;
        
        int ans = 0;
        int[] map2 = new int[26];
        int j = -1;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char cha = s.charAt(i);
            map2[cha - 'A']++;
            
            if(map2[cha - 'A'] <= map1[cha - 'A'])
                count++;
            
            while(j < i && count == reqd){
                if(ans == 0){
                    ans = i - j;
                }else{
                    ans = Math.min(ans, i - j);
                }
                j++;
                
                char chr = s.charAt(j);
                map2[chr - 'A']--;
                if(map2[chr - 'A'] < map1[chr - 'A']){
                    count--;
                }
            }
        }
        return ans;
    }
}