class Solution {
    public String sortString(String s) {
        int[] map = new int[26];
        
        for(char ch: s.toCharArray()){
            map[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){ 
            for(int i = 0; i < 26; i++){
                if(map[i] != 0){
                    sb.append((char)(i + 'a'));
                    map[i]--;
                }
            }

            for(int i = 25; i >= 0; i--){
                if(map[i] != 0){
                    sb.append((char)(i + 'a'));
                    map[i]--;
                }
            }
        }
        
        return sb.toString();
    }
}