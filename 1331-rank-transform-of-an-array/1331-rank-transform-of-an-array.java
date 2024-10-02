class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
       
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],1);
        }
        int i=1;
        for(Map.Entry<Integer,Integer> e:map.entrySet())
        {
            map.put(e.getKey(),i);
            i++;
        }
        for(i=0;i<n;i++)
        {
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}

