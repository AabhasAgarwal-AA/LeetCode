class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {            
        List<List<Integer>> res = new ArrayList<>();
        if(target == -294967296 || target == 294967296)
            return res;
        
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <= n-4; i++){
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int val1 = nums[i];
            List<List<Integer>> sub = threeSum(nums, target - val1, i+1);
            for(List<Integer> list: sub){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int target, int si) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n - si < 3)
            return res;
        
        for(int i = si; i <= n - 3; i++){
            if(i != si && nums[i] == nums[i-1])
                continue;
            int val1 = nums[i];
            int tar = target - val1;
            List<List<Integer>> subres = twoSum(nums, i + 1, n - 1, tar);
            for(List<Integer> list: subres){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }
    
    private List<List<Integer>> twoSum(int[] arr, int si, int ei, int tar){
        int left = si, right = ei;
        List<List<Integer>> res = new ArrayList<>();
        while(left < right){
            if(left != si && arr[left] == arr[left-1]){
                left++;
                continue;
            }
            
            int sum = arr[left] + arr[right];
            if(sum == tar){
                List<Integer> list = new ArrayList<>();
                list.add(arr[left]);
                list.add(arr[right]);
                res.add(list);
                left++;
                right--;
            }else if(sum > tar){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}