class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] res=new int[n];
        
        for(int i=n-1;i>=0;i--)
        {
            if(dq.isEmpty())
            {
                dq.offerFirst(i);
                res[i]=0;
            }else{
                while(!dq.isEmpty() && temperatures[i]>=temperatures[dq.peekFirst()])
                {
                    dq.pollFirst();
                }
                
                if(dq.isEmpty())
                {
                    res[i]=0;
                }else{
                    res[i]=dq.peekFirst()-i;
                }
                dq.offerFirst(i);
            }
        }
        return res;
    }
}

