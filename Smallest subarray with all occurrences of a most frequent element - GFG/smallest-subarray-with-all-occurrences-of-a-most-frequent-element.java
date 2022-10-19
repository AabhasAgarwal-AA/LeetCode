//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        int si = -1;
        int li = -1;
        int len = 0;
        int mfreq = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> fi = new HashMap<>();
        
        for(int i = 0; i < a.length; i++){
            if(map.containsKey(a[i]) == false){
                map.put(a[i], 1);
                fi.put(a[i], i);
            }else{
                map.put(a[i], map.get(a[i]) + 1);
            }
            
            if(map.get(a[i]) > mfreq){
                mfreq = map.get(a[i]);
                len = i - fi.get(a[i]) + 1;
                si = fi.get(a[i]);
                li = i;
            }else if(map.get(a[i]) == mfreq && i - fi.get(a[i]) + 1 < len){
                len = i - fi.get(a[i]) + 1;
                si = fi.get(a[i]);
                li = i;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = si; i <= li; i++){
            res.add(a[i]);
        }
        
        return res;
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends