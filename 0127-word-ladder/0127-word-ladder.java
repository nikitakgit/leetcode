class Pair{
    String first;
    int second;
    
    Pair(String first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        int n=wordList.size();
        Set<String> st=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            st.add(wordList.get(i));
        }
        
        st.remove(beginWord);
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            String word=p.first;
            int step=p.second;
            
            if(word.equals(endWord)) return step;
            
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String replacedWord=new String(replaced);
                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}