class Solution {
    public boolean isStrictlyPalindromic(int n) {
         boolean ans=false;
       for(int i=2;i<n-2;i++){
           int num=n;
           int anum=0;
           while(num!=0){
               int rem=num%i;
               anum=(anum*10)+(rem);
               num=num/i;
           }
           if(anum==n){
               ans=true;
           }
           else{
               ans=false;
               break;
           }
       }
       return ans;
    }
}