class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char ch: t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        
        int j = -1;
        int count = 0;
        Map<Character, Integer> smap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if(smap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0))
                count++;
            
            while(count == t.length() && j < i){
                String ans = s.substring(j+1, i+1);
                if(res.length() == 0 || res.length() > ans.length())
                    res = ans;
                
                j++;
                char chr = s.charAt(j);
                smap.put(chr, smap.getOrDefault(chr, 0) - 1);
                if(smap.getOrDefault(chr, 0) < tmap.getOrDefault(chr, 0))
                    count--;
            }
        }
        
        
        return res;
    }
}