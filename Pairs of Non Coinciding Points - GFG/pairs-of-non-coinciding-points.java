//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        // code here
        int res = 0;
        
        int xres = 0;
        HashMap<Integer, Integer> xmap = new HashMap<>();
        for(int i = 0; i < N; i++){
            int x = X[i];
            xmap.put(x, xmap.getOrDefault(x, 0) + 1);
        }
        for(int x : xmap.keySet()){
            int freq = xmap.get(x);
            xres += (freq * (freq - 1)) / 2;
        }
        
        int yres = 0;
        HashMap<Integer, Integer> ymap = new HashMap<>();
        for(int i = 0; i < N; i++){
            int y = Y[i];
            ymap.put(y, ymap.getOrDefault(y, 0) + 1);
        }
        for(int y : ymap.keySet()){
            int freq = ymap.get(y);
            yres += (freq * (freq - 1)) / 2;
        }
        
        int xyres = 0;
        HashMap<String, Integer> xymap = new HashMap<>();
        for(int i = 0; i < N; i++){
            int x = X[i];
            int y = Y[i];
            String key = x + "#" + y;
            xymap.put(key, xymap.getOrDefault(key, 0) + 1);
        }
        for(String key: xymap.keySet()){
            int freq = xymap.get(key);
            xyres += (freq * (freq - 1)) / 2;
        }
        
        res = xres + yres - 2 * xyres;
        return res;
    }
};