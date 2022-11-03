class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });
        
        for(char key: map.keySet())
            pq.add(key);
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() != 0){
            char rem = pq.remove();
            for(int i = 0; i < map.get(rem); i++){
                sb.append(rem);
            }
        }
        
        return sb.toString();
    }
}