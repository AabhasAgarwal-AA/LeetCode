class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i = 0; i < 2 * n; i++){
            while(st.getFirst() != -1 && nums[st.getFirst()] < nums[i % n])
                ans[st.removeFirst()] = nums[i % n];
            
            if(i < n)
                st.addFirst(i);
        }
        
        return ans;
    }
}