class Solution {
    public int numSteps(String s) {
       int n=s.length();
       int cnt=0;
       int carry=0;
       for(int i=n-1;i>=1;i--)
       {
           int num=s.charAt(i)-'0';
           if(num==0 && carry==0)
           {
               cnt++;
           }else if(num==1 && carry==1)
           {
               cnt++;
               carry=1;
           }else{
               cnt+=2;
               carry=1;
           }
       }
        if(carry==1) cnt++;
        return cnt;
        
    }
}