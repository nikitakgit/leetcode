class Solution {
    public int[] sortByBits(int[] arr) {
        Comparator<Integer> comp=(a,b) ->{
            int oneA=countOnes(a);
            int oneB=countOnes(b);
            if(oneA!=oneB)
            {
                return oneA-oneB;
            }
            return a-b;
        };
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(comp);
        for(int n:arr)
        {
            pq.offer(n);
        }
        int[] res=new int[arr.length];
        int i=0;
        while(!pq.isEmpty())
        {
            res[i]=pq.poll();
            i++;
        }
        return res;
    }
    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }        
}

