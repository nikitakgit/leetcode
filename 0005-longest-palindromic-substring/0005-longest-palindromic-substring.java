class Solution {
    public String longestPalindrome(String s) {
        int st=0, e=0;
        for(int i=0; i<s.length(); i++){
            int odd=pal(s,i,i);
            int even=pal(s,i,i+1);
            int len=Math.max(odd,even);

            if(len>e-st){
                st=i-(len-1)/2;
                e=i+len/2;
            }
        }
        return s.substring(st,e+1);
    }

    public int pal(String str, int st, int e){
        while(st>=0 && e<str.length() && str.charAt(st)==str.charAt(e)){
            st--;
            e++;
        }
        return e-st-1;
    }
}