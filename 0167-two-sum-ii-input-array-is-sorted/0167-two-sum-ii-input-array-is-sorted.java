class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){
            if(left != 0 && arr[left] == arr[left - 1]){
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if(sum == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(sum > target)
                right--;
            else
                left++;
        }
        
        return res;
    }
}