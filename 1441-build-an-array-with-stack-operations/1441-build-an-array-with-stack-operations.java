class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations=new ArrayList<>();
        
        int curr=1;
        int i=0;
        while(curr<=n && i<target.length)
        {
            int num=target[i];
            if(num==curr)
            {
                operations.add("Push");
                curr++;
                i++;
            }else{
                operations.add("Push");
                operations.add("Pop");
                curr++;
            }
        }
        return operations;
    }
}

