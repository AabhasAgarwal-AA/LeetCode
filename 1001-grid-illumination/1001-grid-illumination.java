class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {0, 0}};
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        HashMap<Integer, Integer> xpyMap = new HashMap<>();
        HashMap<Integer, Integer> xmyMap = new HashMap<>();
        HashMap<Integer, Integer> lampMap = new HashMap<>();
        
        for(int[] lamp : lamps){
            int x = lamp[0], y = lamp[1];
            if(!lampMap.containsKey(x * n + y)){
                rowMap.put(x, rowMap.getOrDefault(x, 0) + 1);
                colMap.put(y, colMap.getOrDefault(y, 0) + 1);
                xpyMap.put(x + y, xpyMap.getOrDefault(x + y, 0) + 1);
                xmyMap.put(x - y, xmyMap.getOrDefault(x - y, 0) + 1);
                lampMap.put(x * n + y, lampMap.getOrDefault(x * n + y, 0) + 1);
            }
        }
        
        int[] ans = new int[queries.length];
        
        for(int k = 0; k < queries.length; k++){
            int x = queries[k][0];
            int y = queries[k][1];
            
            if(rowMap.getOrDefault(x, 0) > 0){
                ans[k] = 1;
            }else if(colMap.getOrDefault(y, 0) > 0){
                ans[k] = 1;
            }else if(xpyMap.getOrDefault(x + y, 0) > 0){
                ans[k] = 1;
            }else if(xmyMap.getOrDefault(x - y, 0) > 0){
                ans[k] = 1;
            }
            for(int[] dir : dirs){
                int i = x + dir[0];
                int j = y + dir[1];
                if(i < 0 || i >= n || j < 0 || j >= n)
                    continue;
                
                if(lampMap.containsKey(i * n + j)){
                    rowMap.put(i, rowMap.getOrDefault(i, 0) - 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) - 1);
                    xpyMap.put(i + j, xpyMap.getOrDefault(i + j, 0) - 1);
                    xmyMap.put(i - j, xmyMap.getOrDefault(i - j, 0) - 1);
                    lampMap.remove(i * n + j);
                }
            }
            
        }
        return ans;
    }
}