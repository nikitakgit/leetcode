class Solution {
    public String removeKdigits(String num, int k) {
      int n = num.length();
        if(k>=n)return "0";
        if (k == 0)
            return num;


        Stack<Character> st = new Stack<>();
        st.push(num.charAt(0));
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                --k;
                st.pop();
            }
            st.push(num.charAt(i));
            if(st.size()==1 && st.peek()=='0'){
                st.pop();
            }
        }
        while(!st.isEmpty() && k>0){
            k--;
            st.pop();
        }
       
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();
        if(result.length()==0){
            return "0";
        }
        return result.toString();
        
    }
}