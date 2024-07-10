class Solution {
    public int calPoints(String[] operations) {
        int ans=0;
        ArrayList<Integer> arr=new ArrayList<>();
        
        
        int pprev=0;
        int prev=0;
        for(int i=0;i<operations.length;i++)
        {
            if(operations[i].charAt(0)=='+')
            {
                arr.add(prev+pprev);
                prev=arr.get(arr.size()-1);
                pprev=arr.get(arr.size()-2);
            }else if(operations[i].charAt(0)=='C')
            {
                arr.remove(arr.size()-1);
                prev=arr.size()>0?arr.get(arr.size()-1):0;
                pprev=arr.size()-1>0?arr.get(arr.size()-2):0;
            }else if(operations[i].charAt(0)=='D')
            {
                arr.add(prev*2);
                prev=arr.get(arr.size()-1);
                pprev=arr.size()-1>0?arr.get(arr.size()-2):0;
            }else{
                arr.add(Integer.parseInt(operations[i]));
                prev=arr.get(arr.size()-1);
                pprev=arr.size()-1>0?arr.get(arr.size()-2):0;
            }
            
        }
        for(int i=0;i<arr.size();i++)
        {
            ans+=arr.get(i);
        }
        return ans;
    }
}