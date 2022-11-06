class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = answers.length;
        int ans = 0;
        
        for(int ele: answers){
            if(!map.containsKey(ele)){
                ans += 1 + ele;
                map.put(ele, 1);
            }else{
                map.put(ele, map.get(ele) + 1);
            }
            
            if(map.get(ele) == ele + 1)
                map.remove(ele);
        }
        return ans;
    }
}