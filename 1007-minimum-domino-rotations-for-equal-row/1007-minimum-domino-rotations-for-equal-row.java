class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int num1 = tops[0], num2 = bottoms[0];
        
        for(int i = 0; i < tops.length; i++){
            if(count1 != (int)1e9){
                if(tops[i] == num1){ 
                    // nothing
                }else if(bottoms[i] == num1){
                    count1++;
                }else{
                    count1 = (int)1e9;
                }
            }
            if(count2 != (int)1e9){
                if(bottoms[i] == num1){ 
                    // nothing
                }else if(tops[i] == num1){
                    count2++;
                }else{
                    count2 = (int)1e9;
                }
            }
            if(count3 != (int)1e9){
                if(bottoms[i] == num2){
                    // nothing
                }else if(tops[i] == num2){
                    count3++;
                }else{
                    count3 = (int)1e9;
                }
            }
            if(count4 != (int)1e9){
                if(tops[i] == num2){
                    // nothing
                }else if(bottoms[i] == num2){
                    count4++;
                }else{
                    count4 = (int)1e9;
                }
            }
        }
        
        int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
        
        return res == (int)1e9 ? -1 : res;
    }
}