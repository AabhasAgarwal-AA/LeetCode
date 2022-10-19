class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){ 
            return new ArrayList<>();
        }
        
        HashMap<Character, Integer> pmap = new HashMap<>();
        for(char ch: p.toCharArray()){
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        int count = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if(smap.getOrDefault(ch, 0) <= pmap.getOrDefault(ch, 0)){ 
                count++;
            }
            
            if(i >= p.length()){ 
                char chr = s.charAt(i - p.length());
                smap.put(chr, smap.get(chr) - 1);
                if(smap.getOrDefault(chr, 0) < pmap.getOrDefault(chr, 0)){
                    count--;
                }
            }   
            if(count == p.length()){ 
                res.add(i - p.length() + 1);
            }
            
        }
        
        return res;
    }
}