class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(start);
        
        while(que.size() > 0){
            int rem = que.removeFirst();
            if(arr[rem] == 0)
                return true;
            
            if(arr[rem] < 0)
                continue;
            
            if(rem + arr[rem] < n)
                que.addLast(rem + arr[rem]);
            
            if(rem - arr[rem] >= 0)
                que.addLast(rem - arr[rem]);
            
            arr[rem] = - arr[rem];
        }
        return false;
    }
}