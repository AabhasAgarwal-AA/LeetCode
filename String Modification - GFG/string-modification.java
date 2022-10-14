//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Rearrange
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            
            int old = str.length();
            int chs[] = new int[26];
            Arrays.fill(chs, 0);
            
            for(int i=0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
                chs[idx]++;
            }
            Solution gfg = new Solution();     
            str = gfg.rearrangeString(str);
            int flag=1,ff=0;
            int chs2[] = new int[26];
            Arrays.fill(chs2, 0);
	        
	        for(int i=0;i<str.length();i++){
	            int idx = str.charAt(i)-'a';
                if(idx>=0&&idx<26)
	            chs2[idx]++;
	        }
	             
	        if(str.length() != old)
	         System.out.println(0);
	        else
	        {
	            
    	        for(int i=0;i<26;i++)
                    if(chs[i] != chs2[i])
                        ff=1;
                
                if(ff==1){
                        System.out.println(0);
                }
                else{
        	        if(str != "-1"){
                    	for(int i=1;i<str.length();i++)
                    	{
                    		if(str.charAt(i-1) == str.charAt(i))
                    			flag=0;
                    	}
                    	if(flag == 1)
                    		System.out.println(1);
                    	else
                    	System.out.println(0 );
                    }
    	            else
    	            	System.out.println(0);
                }
            }
        }
    }
}
// } Driver Code Ends


/* The below function should return 
the transformed string */
class Solution
{
    static class Pair implements Comparable<Pair>{
        int ch;
        int freq;
        Pair(int ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return o.freq - this.freq;
        }
    }
   
   public static String rearrangeString(String str)
   {
       //Your code here
       int[] map = new int[26];
       for(char ch: str.toCharArray()){
           map[ch - 'a']++;
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       for(int i = 0; i < 26; i++){
           if(map[i] > 0){
               pq.add(new Pair(i, map[i]));
           }
       }
       
       StringBuilder sb = new StringBuilder();
       Pair prev = null;
       
       while(pq.size() > 0){
           Pair rem = pq.remove();
           rem.freq--;
           char ch = (char)('a' + rem.ch);
           sb.append(ch);
           if(prev != null && prev.freq > 0){
               pq.add(prev);
           }
           prev = rem;
       }
       return sb.toString();
   }
   
}