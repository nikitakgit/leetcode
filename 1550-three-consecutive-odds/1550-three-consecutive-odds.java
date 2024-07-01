class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
       int cnt=0;
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]%2;
            sum+=arr[i];
        }
        if(sum<3) return false;
        else{
            for(int i=0;i<arr.length-2;i++)
            {
                if((arr[i]+arr[i+1]+arr[i+2])==3) return true;
            }
        }
        return false;
    }
}