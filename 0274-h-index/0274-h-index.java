class Solution {
    public int hIndex(int[] citations) {
       int l=0, h=citations.length;
        while(l<h)
        {
            int m=(l+h+1)/2;
            int count=0;
            for(int i=0;i<citations.length;i++)
            {
                if(citations[i]>=m)
                {
                    count++;
                }
            }
            if(count>=m)
            {
                l=m;
            }else{
                h=m-1;
            }
        }
        return l;
    }
}