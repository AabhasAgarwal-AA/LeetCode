class Solution {
    public int numberOfSubstrings(String s) {
        return atMostK(s, 3) - atMostK(s, 2);
    }
    private int atMostK(String s, int k){
        int res = 0;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char chi = s.charAt(i);
            map.put(chi, map.getOrDefault(chi, 0) + 1);
            
            while(i > j && map.size() > k){
                j++;
                char chj = s.charAt(j);
                map.put(chj, map.get(chj) - 1);
                if(map.get(chj) == 0)
                    map.remove(chj);
            }
            res += (i - j);
        }
        return res;
    }
}