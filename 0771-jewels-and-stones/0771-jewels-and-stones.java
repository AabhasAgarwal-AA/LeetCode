class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: jewels.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for(char ch: stones.toCharArray()){
            if(map.containsKey(ch))
                count++;
        }
        
        return count;
    }
}