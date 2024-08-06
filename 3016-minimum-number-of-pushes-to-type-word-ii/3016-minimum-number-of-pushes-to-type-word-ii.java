class Solution {
    public int minimumPushes(String word) {
        int cnt=0;
        int res=0;
        int[] freq=new int[26];
        for(char c:word.toCharArray())
        {
            freq[c-'a']++;
        }
        
        Arrays.sort(freq);
        for(int i=25;i>=0;i--)
        {
            res+=freq[i]*(cnt++/8+1);
        }
        return res;
    }
}