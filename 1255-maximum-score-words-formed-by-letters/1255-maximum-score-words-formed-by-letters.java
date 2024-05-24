class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
       int[] letterCnt=new int[26];
        for(char l:letters)
        {
            letterCnt[l-'a']++;
        }
        return dfs(words,score,letterCnt,0);
    }
    public int dfs(String[] words,int[] score,int[] letterCnt,int i)
    {
        if(i==words.length) return 0;
        int skipScore=dfs(words,score,letterCnt,i+1);
        int wordScore=0;
        int[] newLetterCnt=letterCnt.clone();
        boolean valid=true;
        for(char c:words[i].toCharArray())
        {
            if(newLetterCnt[c-'a']==0)
            {
                valid=false;
                break;
            }
            newLetterCnt[c-'a']--;
            wordScore+=score[c-'a'];
        }
        int takeScore=0;
        if(valid)
        {
            takeScore=wordScore+dfs(words,score,newLetterCnt,i+1);
        }
        return Math.max(skipScore,takeScore);
    }
}