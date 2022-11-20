class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        LinkedList<Integer> st = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sign = 1;
                sum += val;
            }else if(ch == '('){
                st.addFirst(sum);
                st.addFirst(sign);
                sum = 0;
                sign = 1;
            }else if(ch == ')'){
                sum *= st.removeFirst();
                sum += st.removeFirst();
            }else if(ch == '-'){
                sign *= -1;
            }
        }
        
        return sum;
    }
}