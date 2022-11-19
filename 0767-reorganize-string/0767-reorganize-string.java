class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        int max = freq[0];
        int letter = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] > max){
                max = freq[i];
                letter = i;
            }
        }
        
        if(max > (s.length() + 1)/ 2)
            return "";
        
        int idx = 0;
        char[] charr = new char[s.length()];
        
        while(freq[letter] > 0){
            charr[idx] = (char)(letter + 'a');
            freq[letter]--;
            idx += 2;
        }
        
        for(int i = 0; i < 26; i++){
            while(freq[i] > 0){
                if(idx >= s.length())
                    idx = 1;
                charr[idx] = (char)(i + 'a');
                freq[i]--;
                idx += 2;
            }
        }
        return String.valueOf(charr);
    }
}