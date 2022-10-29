class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        for(int[] road: roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }
        long ans = 0;
        long x = 1;
        Arrays.sort(degree);
        for(long val: degree){
            ans += val * x;
            x++;
        }
        return ans;
    }
}