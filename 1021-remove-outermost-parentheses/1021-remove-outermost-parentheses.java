class Solution {
    public String removeOuterParentheses(String s) {
        int len=s.length();
        if(len<=2) return "";
        char[] c=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int opn=1;
        for(int i=1;i<len;i++)
        {
            if(c[i]=='(')
            {
                opn++;
                if(opn>1) sb.append('(');
            }else{
                if(opn>1) sb.append(')');
                opn--;
            }
        }
        return sb.toString();
    }
}

