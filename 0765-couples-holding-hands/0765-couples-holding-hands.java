class Solution {
    int[] par;
    int count;
    
    int findPar(int i){
        return par[i] == i ? i : (par[i] = findPar(par[i]));
    }
    
    void union(int i, int j){
        int il = findPar(i), jl = findPar(j);
        
        if(il != jl){
            par[il] = jl;
            count--;
        }
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        par = new int[n];
        count = n;
        for(int i = 0; i < n; i++)
            par[i] = i;
        
        for(int i = 0; i < n; i++){
            int val1 = row[i * 2];
            int val2 = row[i * 2 + 1];
            union(val1/2, val2/ 2);
        }
        
        
        return n - count;
    }
}