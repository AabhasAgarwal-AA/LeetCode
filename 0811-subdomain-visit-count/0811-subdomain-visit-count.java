class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String domain: cpdomains){
            String[] temp = domain.split(" ");
            
            int visCount = Integer.parseInt(temp[0]);
            String[] words = temp[1].split("\\.");
            
            StringBuilder sb = new StringBuilder();
            
            for(int idx = words.length - 1; idx >= 0; idx--){
                if(idx == words.length - 1){
                    sb.append(words[idx]);
                }else{
                    sb.insert(0, ".");
                    sb.insert(0, words[idx]);
                }
                
                String subDomain = sb.toString();
                map.put(subDomain, map.getOrDefault(subDomain, 0) + visCount);
            }
        }
        
        List<String> res = new ArrayList<>();
        for(String subDomain: map.keySet()){
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(subDomain));
            sb.append(" ");
            sb.append(subDomain);
            
            res.add(sb.toString());
        }
        
        return res;
    }
}