class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        permute(nums, 0, ans, smallAns);
        return ans;
    }
    private int permute(int[] nums, int eleUsed, List<List<Integer>> ans, List<Integer> smallAns){
        if(eleUsed == nums.length){
            ans.add(new ArrayList<>(smallAns));
            return 1;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > -15){
                int val = nums[i];
                nums[i] = -15;
                smallAns.add(val);
                
                count += permute(nums, eleUsed + 1, ans, smallAns);
                
                nums[i] = val;
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }
}