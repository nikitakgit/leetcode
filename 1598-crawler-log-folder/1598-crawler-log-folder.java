class Solution {
    public int minOperations(String[] logs) {
        int cnt=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].charAt(0)=='.')
            {
                if(logs[i].charAt(1)=='.')
                {
                    cnt--;
                    if(cnt<0) cnt=0;
                }
            }else{
                cnt++;
            }
        }
        return cnt;
    }
}