class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        
        String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> ans = new ArrayList<>();
        letterCombi(digits, 0, codes, ans, "");
        return ans;
    }
    
    private int letterCombi(String digits, int idx, String[] codes, List<String> ans, String psf){
        if(idx == digits.length()){
            ans.add(psf);
            return 1;
        }
        int count = 0;
        int val = digits.charAt(idx) - '0';
        String code = codes[val];
        
        for(int i = 0; i < code.length(); i++){
            count += letterCombi(digits, idx + 1, codes, ans, psf + code.charAt(i));
        }
        
        return count;
    }
}