class Solution {
    public boolean judgeSquareSum(int c) {
        
        long root=0;
        long l=1;
        long r=c;
        
        //binary search to find integer squareRoot of c
        while(l<=r)
        {
            long mid=l+(r-l)/2;
            long product=mid*mid;
            if(product==c) return true;
            else if(product>c)
            {
                r=mid-1;
            }else{
                root=mid;
                l=mid+1;
            }
        }
        
        l=0;
        r=root;
        
        // Two pointer approach to find if two squares sum to c
        
        while(l<=r)
        {
            long product=l*l+r*r;
            if(product==c) return true;
            else if(product<c) l++;
            else r--;
        }
        return false;
    }
}