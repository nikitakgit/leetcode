class Solution {
    public int maximumGain(String s, int x, int y) {
       int aCnt=0;
        int bCnt=0;
        int less=Math.min(x,y);
        int res=0;
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c>'b')
            {
                res+=Math.min(aCnt,bCnt)*less;
                aCnt=0;
                bCnt=0;
            }else if(c=='a')
            {
                if(x<y && bCnt>0)
                {
                    bCnt--;
                    res+=y;
                }else{
                    aCnt++;
                }
            }else{
                if(x>y && aCnt>0)
                {
                    aCnt--;
                    res+=x;
                }else{
                    bCnt++;
                }
            }
        }
        res+=Math.min(aCnt,bCnt)*less;
        return res;
    }
}
