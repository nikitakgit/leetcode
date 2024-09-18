class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int total=0;
        int gasAvailable=0;
        int ind=0;
        for(int i=0;i<n;i++)
        {
            total+=gas[i]-cost[i];
            gasAvailable+=gas[i]-cost[i];
            if(gasAvailable<0)
            {
                gasAvailable=0;
                ind=i+1;
            }
        }
        
        return total<0?-1:ind;
    }
}



