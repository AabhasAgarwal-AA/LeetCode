class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <= n - 3; i++){
            if(i != 0 && nums[i] == nums[i-1])
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