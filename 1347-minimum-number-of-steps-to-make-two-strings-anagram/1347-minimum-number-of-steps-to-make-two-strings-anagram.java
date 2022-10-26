class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(map[i] > 0)
                count += map[i];
        }
        
        return count;
    }
}