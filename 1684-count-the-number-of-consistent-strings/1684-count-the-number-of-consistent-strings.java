class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set=new HashSet<>();
        for(char c:allowed.toCharArray())
        {
            set.add(c);
        }
        
        int cnt=words.length;
        for(int i=0;i<words.length;i++)
        {
            String word=words[i];
            int cnt1=0;
            for(int j=0;j<word.length();j++)
            {
                if(!set.contains(word.charAt(j)))
                {
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}