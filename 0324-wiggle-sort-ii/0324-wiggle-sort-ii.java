class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 1, j = n - 1;
        int[] res = new int[n];
        
        while(i < n){
            res[i] = nums[j];
            i += 2;
            j--;
        }
        i = 0;
        while(i < n){
            res[i] = nums[j];
            i+= 2;
            j--;
        }
        i = 0;
        for(i = 0; i < n; i++)
            nums[i] = res[i];
    }
}