class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       Set<String> dict=new HashSet<>(dictionary);
        StringBuilder ans=new StringBuilder();
        String[] words=sentence.split(" ");
        for(String word:words)
        {
            if(ans.length()>0)
            {
                ans.append(" ");
            }
            ans.append(findRoot(word,dict));
        }
        return ans.toString();
    }
       private String findRoot(String word,Set<String> dict)
       {
           for(int i=1;i<=word.length();i++)
           {
               String prefix=word.substring(0,i);
               if(dict.contains(prefix))
               {
                   return prefix;
               }
           }
           return word;
       }
}

