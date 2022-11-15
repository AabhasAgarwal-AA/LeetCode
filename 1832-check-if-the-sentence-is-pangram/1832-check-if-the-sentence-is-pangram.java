class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int size = 0;
        for(char ch: sentence.toCharArray()){
            if(arr[ch - 'a'] == 0){
                arr[ch - 'a']++;
                size++;
            }else{
                arr[ch - 'a']++;
            }
        }
        return size == 26;
    }
}