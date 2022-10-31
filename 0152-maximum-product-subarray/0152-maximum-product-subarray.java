class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int maxProduct = -(int)1e9;
        for(int i = 0; i < nums.length; i++){
            int product = nums[i];
            maxProduct = Math.max(product, maxProduct);
            for(int j = i + 1; j < nums.length; j++){
                product = product * nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }
}