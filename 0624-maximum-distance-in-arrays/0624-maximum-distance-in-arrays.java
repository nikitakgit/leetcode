class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int mini=arrays.get(0).get(0);
        int maxi=arrays.get(0).get(arrays.get(0).size()-1);
        int maxDist=0;
        
        for(int i=1;i<arrays.size();i++)
        {
            List<Integer> curArr=arrays.get(i);
            maxDist=Math.max(maxDist,
                             Math.max(Math.abs(curArr.get(curArr.size()-1)-mini),
                             Math.abs(maxi-curArr.get(0))));
            
            mini=Math.min(mini,curArr.get(0));
            maxi=Math.max(maxi,curArr.get(curArr.size()-1));
        }
        return maxDist;
    }
}

